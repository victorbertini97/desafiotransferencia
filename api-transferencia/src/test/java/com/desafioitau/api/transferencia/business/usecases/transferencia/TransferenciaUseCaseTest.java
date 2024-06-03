package com.desafioitau.api.transferencia.business.usecases.transferencia;

import static java.lang.String.format;
import static net.bytebuddy.utility.RandomString.make;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.desafioitau.api.transferencia.adapters.AtualizarSaldoContaAdapter;
import com.desafioitau.api.transferencia.adapters.NotificarBacenAdapter;
import com.desafioitau.api.transferencia.adapters.ProcurarContaAdapter;
import com.desafioitau.api.transferencia.adapters.RegistrarTransferenciaAdapter;
import com.desafioitau.api.transferencia.business.exceptions.ResourceNotFoundException;
import com.desafioitau.api.transferencia.business.exceptions.ValidationException;
import com.desafioitau.api.transferencia.business.models.Conta;
import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.business.usecases.transferencia.validators.TransferenciaValidator;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

@ExtendWith(MockitoExtension.class)
class TransferenciaUseCaseTest {

    @Mock private ProcurarContaAdapter procurarContaAdapter;
    @Spy  private Collection<TransferenciaValidator> validators = new ArrayList<>();
    @Mock private AtualizarSaldoContaAdapter atualizarSaldoContaAdapter;
    @Mock private NotificarBacenAdapter notificarBacenAdapter;
    @Mock private RegistrarTransferenciaAdapter registrarTransferenciaAdapter;

    @InjectMocks private TransferenciaUseCase transferenciaUseCase;

    @Test
    void dadoTransferir_quandoContaOrigemInvalida_entaoLancaExcecao() {

        // Dado:
        final var idOrigem      = UUID.randomUUID().toString();
        final var transferencia = mockTransferencia(idOrigem);

        when(procurarContaAdapter.procurarConta(idOrigem)).thenReturn(Optional.empty());

        // Quando:
        final var excecao = assertThrows(ResourceNotFoundException.class, () -> transferenciaUseCase.transferir(transferencia));

        // Entao:
        assertEquals(format("Conta não encontrada '%s'.", idOrigem), excecao.getMessage());

    }

    @Test
    void dadoTransferir_quandoTransferenciaInvalida_entaoLancaExcecao() {

        // Dado:
        final var idOrigem      = UUID.randomUUID().toString();
        final var transferencia = mockTransferencia(idOrigem);

        when(procurarContaAdapter.procurarConta(idOrigem)).thenReturn(Optional.of(mock(ContaResponse.class)));

        final var message = make();
        validators.add((contaResponse, transferencia1) -> { throw new ValidationException(message); });

        // Quando:
        final var excecao = assertThrows(ValidationException.class, () -> transferenciaUseCase.transferir(transferencia));

        // Entao:
        assertEquals(message, excecao.getMessage());

    }

    @Test
    void dadoTransferir_quandoTransferenciaValida_entaoRealizaTransferencia() {

        // Dado:
        final var contaOrigem   = mock(ContaResponse.class);
        final var idOrigem      = UUID.randomUUID().toString();
        final var transferencia = mockTransferencia(idOrigem);
        final var validator     = mock(TransferenciaValidator.class);

        when(procurarContaAdapter.procurarConta(idOrigem)).thenReturn(Optional.of(contaOrigem));

        validators.add(validator);

        // Quando:
        transferenciaUseCase.transferir(transferencia);

        // Entao:
        final var inOrder = inOrder(validator, atualizarSaldoContaAdapter, notificarBacenAdapter, registrarTransferenciaAdapter);
        inOrder.verify(validator).validar(contaOrigem, transferencia);
        inOrder.verify(atualizarSaldoContaAdapter).atualizarSaldoConta(transferencia);
        inOrder.verify(notificarBacenAdapter).notificarBacen(transferencia);
        inOrder.verify(registrarTransferenciaAdapter).registrarTransferencia(transferencia);

    }

    private Transferencia mockTransferencia(final String idOrigem) {
        final Conta contaOrigem = when(mock(Conta.class).getIdOrigem()).thenReturn(idOrigem).getMock();
        return when(mock(Transferencia.class).getConta()).thenReturn(contaOrigem).getMock();
    }

}