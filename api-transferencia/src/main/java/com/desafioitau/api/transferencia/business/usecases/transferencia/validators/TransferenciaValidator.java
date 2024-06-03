package com.desafioitau.api.transferencia.business.usecases.transferencia.validators;

import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

public interface TransferenciaValidator {
    void validar(final ContaResponse contaResponse, final Transferencia transferencia);
}