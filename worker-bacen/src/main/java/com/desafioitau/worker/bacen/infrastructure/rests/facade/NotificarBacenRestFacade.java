package com.desafioitau.worker.bacen.infrastructure.rests.facade;

import org.springframework.stereotype.Component;

import com.desafioitau.worker.bacen.adapters.NotificarBacenAdapter;
import com.desafioitau.worker.bacen.business.dominio.Transferencia;
import com.desafioitau.worker.bacen.infrastructure.rests.BacenRest;
import com.desafioitau.worker.bacen.infrastructure.rests.mappers.TransferenciaToNotificacaoRequestMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class NotificarBacenRestFacade implements NotificarBacenAdapter {

    private final TransferenciaToNotificacaoRequestMapper toNotificacaoRequestMapper;
    private final BacenRest bacenRest;

    @Override
    public void notificarBacen(Transferencia transferencia) {
        final var notificacaoRequest = toNotificacaoRequestMapper.toNotificacaoRequest(transferencia);
        bacenRest.notificarBacen(notificacaoRequest);
    }

}