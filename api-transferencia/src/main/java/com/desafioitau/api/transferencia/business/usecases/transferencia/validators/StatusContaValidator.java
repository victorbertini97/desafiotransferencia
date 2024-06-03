package com.desafioitau.api.transferencia.business.usecases.transferencia.validators;

import static java.lang.Boolean.TRUE;
import static java.lang.String.format;

import org.springframework.stereotype.Component;

import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.business.exceptions.ValidationException;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

@Component
public class StatusContaValidator implements TransferenciaValidator {

    private static final String ERRO_CONTA_NAO_ATIVA = "Conta '%s' indisponível para efetuar transferências.";

    @Override
    public void validar(final ContaResponse contaResponse, final Transferencia transferencia) {
        final var isContaAtiva = TRUE.equals(contaResponse.getAtivo());
        if(!isContaAtiva) throw new ValidationException(format(ERRO_CONTA_NAO_ATIVA, contaResponse.getId()));
    }

}