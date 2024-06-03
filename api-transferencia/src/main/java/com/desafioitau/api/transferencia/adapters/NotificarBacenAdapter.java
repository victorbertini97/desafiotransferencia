package com.desafioitau.api.transferencia.adapters;

import com.desafioitau.api.transferencia.business.models.Transferencia;

public interface NotificarBacenAdapter {
    void notificarBacen(final Transferencia transferencia);
}