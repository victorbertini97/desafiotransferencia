package com.desafioitau.api.transferencia.infrastructure.rests.facade;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.desafioitau.api.transferencia.infrastructure.rests.ClientesRest;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ClienteResponse;

@ExtendWith(MockitoExtension.class)
class ProcurarClienteRestFacadeTest {

    @Mock private ClientesRest clientesRest;
    @InjectMocks private ProcurarClienteRestFacade procurarClienteRestFacade;

    @Test
    void dadoProcurarCliente_quandoClienteExistir_entaoRetornaVerdadeiro() {
        // Dado:
        final var idCliente = UUID.randomUUID().toString();

        when(clientesRest.procurarCliente(idCliente)).thenReturn(Optional.of(mock(ClienteResponse.class)));

        // Quando:
        final var existe = procurarClienteRestFacade.procurarCliente(idCliente);

        // Entao:
        assertTrue(existe);

    }

    @Test
    void dadoProcurarCliente_quandoClienteNaoExistir_entaoRetornaFalso() {
        // Dado:
        final var idCliente = UUID.randomUUID().toString();

        when(clientesRest.procurarCliente(idCliente)).thenReturn(Optional.empty());

        // Quando:
        final var existe = procurarClienteRestFacade.procurarCliente(idCliente);

        // Entao:
        assertFalse(existe);

    }

}