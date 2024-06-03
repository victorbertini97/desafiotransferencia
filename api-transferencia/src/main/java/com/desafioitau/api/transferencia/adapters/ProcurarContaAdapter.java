package com.desafioitau.api.transferencia.adapters;

import java.util.Optional;

import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

public interface ProcurarContaAdapter {
    Optional<ContaResponse> procurarConta(final String idConta);
}