package com.desafioitau.api.transferencia.infrastructure.rests.facade;

import com.desafioitau.api.transferencia.infrastructure.rests.ContasRest;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProcurarContaRestFacadeTest {

    @Mock private ContasRest apiContaClient;
    @InjectMocks private ProcurarContaRestFacade procurarContaRestFacade;

    @Test
    void dadoProcurarConta_quandoContaExistir_entaoRetornaVerdadeiro() {
        // Dado:
        final var idConta = randomUUID().toString();

        final var contaOrigem = mock(ContaResponse.class);
        when(apiContaClient.procurarConta(idConta)).thenReturn(of(contaOrigem));

        // Quando:
        final var contaOrigemOptional = procurarContaRestFacade.procurarConta(idConta);

        // Entao:
        assertTrue(contaOrigemOptional.isPresent());
        assertEquals(contaOrigem, contaOrigemOptional.get());

    }

    @Test
    void dadoProcurarConta_quandoContaNaoExistir_entaoRetornaFalso() {
        // Dado:
        final var idConta = randomUUID().toString();

        when(apiContaClient.procurarConta(idConta)).thenReturn(empty());

        // Quando:
        final var contaOrigemOptional = procurarContaRestFacade.procurarConta(idConta);

        // Entao:
        assertFalse(contaOrigemOptional.isPresent());
    }
}