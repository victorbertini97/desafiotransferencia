package com.desafioitau.worker.bacen.business.usecases.notificarbacen;

import org.springframework.stereotype.Component;

import com.desafioitau.worker.bacen.adapters.InformarTransferenciaRealizadaAdapter;
import com.desafioitau.worker.bacen.adapters.NotificarBacenAdapter;
import com.desafioitau.worker.bacen.business.dominio.Transferencia;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class NotificarBacenUseCase {

    private final NotificarBacenAdapter notificarBacenAdapter;
    private final InformarTransferenciaRealizadaAdapter informarTransferenciaRealizadaAdapter;

    public void notificarBacen(final Transferencia transferencia) {
        notificarBacenAdapter.notificarBacen(transferencia);
        informarTransferenciaRealizadaAdapter.informarTransferenciaRealizada(transferencia);
    }

}