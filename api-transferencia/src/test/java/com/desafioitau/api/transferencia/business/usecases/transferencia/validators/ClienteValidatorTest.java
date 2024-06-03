package com.desafioitau.api.transferencia.business.usecases.transferencia.validators;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.desafioitau.api.transferencia.adapters.ProcurarClienteAdapter;
import com.desafioitau.api.transferencia.business.exceptions.ResourceNotFoundException;
import com.desafioitau.api.transferencia.business.models.Transferencia;

@ExtendWith(MockitoExtension.class)
public class ClienteValidatorTest {

    @Mock private ProcurarClienteAdapter procurarClienteAdapter;
    @InjectMocks private ClienteValidator clienteValidator;

    @Test
    void dadoValidar_quandoClienteExistir_entaoNaoFazNada() {

        // Dado:
        final var idCliente = UUID.randomUUID().toString();

        final Transferencia transferencia = when(mock(Transferencia.class).getIdCliente()).thenReturn(idCliente).getMock();

        when(procurarClienteAdapter.procurarCliente(idCliente)).thenReturn(true);

        // Quando:
        clienteValidator.validar(null, transferencia);

        // Entao:
        verify(procurarClienteAdapter).procurarCliente(idCliente);

    }

    @Test
    void dadoValidar_quandoClienteNaoExistir_entaoLancaExcecao() {

        // Dado:
        final var idCliente = UUID.randomUUID().toString();

        final Transferencia transferencia = when(mock(Transferencia.class).getIdCliente()).thenReturn(idCliente).getMock();

        when(procurarClienteAdapter.procurarCliente(idCliente)).thenReturn(false);

        // Quando:
        final var excecao = assertThrows(ResourceNotFoundException.class, () -> clienteValidator.validar(null, transferencia));

        // Entao:
        assertEquals(format("Cliente não encontrado '%s'.", idCliente), excecao.getMessage());

    }

}