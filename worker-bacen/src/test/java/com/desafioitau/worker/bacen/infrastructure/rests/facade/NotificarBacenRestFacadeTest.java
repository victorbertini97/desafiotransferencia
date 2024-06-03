package com.desafioitau.worker.bacen.infrastructure.rests.facade;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.desafioitau.worker.bacen.business.dominio.Transferencia;
import com.desafioitau.worker.bacen.infrastructure.rests.BacenRest;
import com.desafioitau.worker.bacen.infrastructure.rests.mappers.TransferenciaToNotificacaoRequestMapper;
import com.desafioitau.worker.bacen.infrastructure.rests.models.NotificacaoRequest;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificarBacenRestFacadeTest {

    @Mock private TransferenciaToNotificacaoRequestMapper toNotificacaoRequestMapper;
    @Mock private BacenRest bacenRest;
    @InjectMocks private NotificarBacenRestFacade notificarBacenRestFacade;

    @Test
    void dadoNotificarBacen_quandoChamado_entaoRealizaNotificacao() {

        // Dado:
        final var transferencia = mock(Transferencia.class);
        final var notificacaoRequest = mock(NotificacaoRequest.class);

        when(toNotificacaoRequestMapper.toNotificacaoRequest(transferencia)).thenReturn(notificacaoRequest);

        // Quando:
        notificarBacenRestFacade.notificarBacen(transferencia);

        // Entao:
        verify(bacenRest).notificarBacen(notificacaoRequest);

    }

}