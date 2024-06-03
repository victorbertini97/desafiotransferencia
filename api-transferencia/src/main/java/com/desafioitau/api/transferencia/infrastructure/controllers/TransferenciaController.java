package com.desafioitau.api.transferencia.infrastructure.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafioitau.api.transferencia.adapters.TransferenciaAdapter;
import com.desafioitau.api.transferencia.business.usecases.transferencia.TransferenciaUseCase;
import com.desafioitau.api.transferencia.infrastructure.controllers.mappers.TransferenciaRequestToTransferenciaMapper;
import com.desafioitau.api.transferencia.infrastructure.controllers.models.TransferenciaRequest;
import com.desafioitau.api.transferencia.infrastructure.controllers.models.TransferenciaResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class TransferenciaController implements TransferenciaAdapter {

    private final TransferenciaRequestToTransferenciaMapper toTransferenciaMapper;
    private final TransferenciaUseCase transferenciaUseCase;

    @Override
    @PostMapping("/transferencia")
    public TransferenciaResponse transferir(@Validated @RequestBody final TransferenciaRequest transferenciaRequest) {
        final var transferencia = toTransferenciaMapper.toTransferencia(transferenciaRequest);
        final var uuidTransferencia = transferenciaUseCase.transferir(transferencia);
        return new TransferenciaResponse(uuidTransferencia);
    }

}