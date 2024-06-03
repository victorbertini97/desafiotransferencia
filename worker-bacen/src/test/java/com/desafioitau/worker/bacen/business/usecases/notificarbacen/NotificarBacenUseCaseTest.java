package com.desafioitau.worker.bacen.business.usecases.notificarbacen;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.desafioitau.worker.bacen.adapters.InformarTransferenciaRealizadaAdapter;
import com.desafioitau.worker.bacen.adapters.NotificarBacenAdapter;
import com.desafioitau.worker.bacen.business.dominio.Transferencia;

@ExtendWith(MockitoExtension.class)
class NotificarBacenUseCaseTest {

    @Mock private NotificarBacenAdapter notificarBacenAdapter;
    @Mock private InformarTransferenciaRealizadaAdapter informarTransferenciaRealizadaAdapter;
    @InjectMocks private NotificarBacenUseCase notificarBacenUseCase;

    @Test
    void dadoNotificarBacen_quandoChamado_entaoNotificaBacenConfirmaTransferencia() {

        // Dado:
        final var transferencia = mock(Transferencia.class);

        // Quando:
        notificarBacenUseCase.notificarBacen(transferencia);

        // Entao:
        final var inOrder = inOrder(notificarBacenAdapter, informarTransferenciaRealizadaAdapter);
        inOrder.verify(notificarBacenAdapter).notificarBacen(transferencia);
        inOrder.verify(informarTransferenciaRealizadaAdapter).informarTransferenciaRealizada(transferencia);

    }

}