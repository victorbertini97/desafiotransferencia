package com.desafioitau.api.transferencia.adapters;

import com.desafioitau.api.transferencia.infrastructure.controllers.models.TransferenciaRequest;
import com.desafioitau.api.transferencia.infrastructure.controllers.models.TransferenciaResponse;

public interface TransferenciaAdapter {
    TransferenciaResponse transferir(final TransferenciaRequest transferenciaRequest);
}