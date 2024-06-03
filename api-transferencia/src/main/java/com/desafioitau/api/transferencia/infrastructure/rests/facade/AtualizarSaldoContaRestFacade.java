package com.desafioitau.api.transferencia.infrastructure.rests.facade;

import com.desafioitau.api.transferencia.infrastructure.rests.ContasRest;
import com.desafioitau.api.transferencia.infrastructure.rests.mappers.TransferenciaToTransferenciaRequestMapper;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import com.desafioitau.api.transferencia.adapters.AtualizarSaldoContaAdapter;
import com.desafioitau.api.transferencia.business.models.Transferencia;

@Component
@AllArgsConstructor
public class AtualizarSaldoContaRestFacade implements AtualizarSaldoContaAdapter {

    private final TransferenciaToTransferenciaRequestMapper toTransferenciaRequestMapper;
    private final ContasRest contasRest;

    @Override
    public void atualizarSaldoConta(@NotNull final Transferencia transferencia) {
        final var transferenciaRequest = toTransferenciaRequestMapper.toTransferenciaRequest(transferencia);
        contasRest.atualizarSaldoConta(transferenciaRequest);
    }

}