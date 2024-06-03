package com.desafioitau.worker.bacen.adapters;

import com.desafioitau.worker.bacen.business.dominio.Transferencia;

public interface NotificarBacenAdapter {
    void notificarBacen(final Transferencia transferencia);
}