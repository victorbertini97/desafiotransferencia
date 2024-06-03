package com.desafioitau.api.transferencia.business.usecases.transferencia.validators;

import org.springframework.stereotype.Component;

import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.business.exceptions.ValidationException;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

@Component
public class SaldoContaValidator implements TransferenciaValidator {

    private static final String ERRO_SALDO_NAO_DISPONIVEL = "Saldo insuficiente para efetuar transferência.";

    @Override
    public void validar(final ContaResponse contaResponse, final Transferencia transferencia) {
        final var hasSaldo = contaResponse.getSaldo().compareTo(transferencia.getValor()) >= 0;
        if(!hasSaldo) throw new ValidationException(ERRO_SALDO_NAO_DISPONIVEL);
    }

}