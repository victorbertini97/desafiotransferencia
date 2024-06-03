package com.desafioitau.api.transferencia.infrastructure.rests.facade;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.infrastructure.rests.ContasRest;
import com.desafioitau.api.transferencia.infrastructure.rests.mappers.TransferenciaToTransferenciaRequestMapper;
import com.desafioitau.api.transferencia.infrastructure.rests.models.TransferenciaRequest;

@ExtendWith(MockitoExtension.class)
class AtualizarSaldoContaRestFacadeTest {

    @Mock private TransferenciaToTransferenciaRequestMapper toTransferenciaRequestMapper;
    @Mock private ContasRest contasRest;
    @InjectMocks private AtualizarSaldoContaRestFacade atualizarSaldoContaRestFacade;

    @Test
    void dadoAtualizarSaldoConta_quandoChamado_entaoAtualizaSaldoConta() {

        // Dado:
        final var transferencia = mock(Transferencia.class);

        final var transferenciaRequest = mock(TransferenciaRequest.class);
        when(toTransferenciaRequestMapper.toTransferenciaRequest(transferencia)).thenReturn(transferenciaRequest);

        // Quando:
        atualizarSaldoContaRestFacade.atualizarSaldoConta(transferencia);

        // Entao:
        verify(contasRest).atualizarSaldoConta(transferenciaRequest);
    }

}