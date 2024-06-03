package com.desafioitau.api.transferencia.business.usecases.transferencia.validators;

import org.springframework.stereotype.Component;

import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.business.exceptions.ValidationException;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

@Component
public class LimiteDiarioTransferenciaValidator implements TransferenciaValidator {

    private static final String ERRO_LIMITE_DIARIO_NAO_DISPONIVEL = "Limite diário indisponível para efetuar transferência.";

    @Override
    public void validar(final ContaResponse contaResponse, final Transferencia transferencia) {
        final var hasLimiteDiario = contaResponse.getLimiteDiario().compareTo(transferencia.getValor()) >= 0;
        if(!hasLimiteDiario) throw new ValidationException(ERRO_LIMITE_DIARIO_NAO_DISPONIVEL);
    }

}