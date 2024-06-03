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
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

@ExtendWith(MockitoExtension.class)
class StatusContaValidatorTest {

    @InjectMocks private StatusContaValidator statusContaValidator;

    @Test
    void dadoValidar_quandoContaAtiva_entaoNaoFazNada() {

        // Dado:
        final ContaResponse contaOrigem = when(mock(ContaResponse.class).getAtivo()).thenReturn(true).getMock();

        // Quando:
        statusContaValidator.validar(contaOrigem, null);

    }

    @Test
    void dadoValidar_quandoContaInativa_entaoLancaExcecao() {

        // Dado:
        final ContaResponse contaOrigem = when(mock(ContaResponse.class).getAtivo()).thenReturn(false).getMock();

        // Quando:
        final var excecao = assertThrows(ValidationException.class, () -> statusContaValidator.validar(contaOrigem, null));

        // Entao:
        assertEquals("Conta 'null' indisponível para efetuar transferências.", excecao.getMessage());

    }
	
}