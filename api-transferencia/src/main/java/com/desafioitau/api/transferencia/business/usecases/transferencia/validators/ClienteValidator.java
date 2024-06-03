package com.desafioitau.api.transferencia.business.usecases.transferencia.validators;

import static java.lang.String.format;

import org.springframework.stereotype.Component;

import com.desafioitau.api.transferencia.adapters.ProcurarClienteAdapter;
import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.business.exceptions.ResourceNotFoundException;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ClienteValidator implements TransferenciaValidator {

    private static final String ERRO_CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado '%s'.";

    private final ProcurarClienteAdapter procurarClienteAdapter;

    @Override
    public void validar(final ContaResponse contaResponse, final Transferencia transferencia) {
        final var idCliente = transferencia.getIdCliente();
        if(!procurarClienteAdapter.procurarCliente(idCliente)) throw new ResourceNotFoundException(format(ERRO_CLIENTE_NAO_ENCONTRADO, idCliente));
    }

}