package com.desafioitau.api.transferencia.business.usecases.transferencia.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.desafioitau.api.transferencia.business.exceptions.ValidationException;
import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

@ExtendWith(MockitoExtension.class)
class SaldoContaValidatorTest {

    @InjectMocks private SaldoContaValidator saldoContaValidator;

    @Test
    void dadoValidar_quandoClientePossuirSaldo_entaoNaoFazNada() {

        // Dado:
        final ContaResponse contaOrigem = when(mock(ContaResponse.class).getSaldo()).thenReturn(10D).getMock();

        final Transferencia transferencia = when(mock(Transferencia.class).getValor()).thenReturn(10D).getMock();

        // Quando:
        saldoContaValidator.validar(contaOrigem, transferencia);

    }

    @Test
    void dadoValidar_quandoClienteNaoPossuirSaldo_entaoLancaExcecao() {

        // Dado:
        final ContaResponse contaOrigem = when(mock(ContaResponse.class).getSaldo()).thenReturn(9D).getMock();

        final Transferencia transferencia = when(mock(Transferencia.class).getValor()).thenReturn(10D).getMock();

        // Quando:
        final var excecao = assertThrows(ValidationException.class, () -> saldoContaValidator.validar(contaOrigem, transferencia));

        // Entao:
        assertEquals("Saldo insuficiente para efetuar transferência.", excecao.getMessage());

    }

}