package com.desafioitau.api.transferencia.infrastructure.controllers.mappers;

import org.mapstruct.Mapper;

import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.infrastructure.controllers.models.TransferenciaRequest;

@Mapper(componentModel = "spring")
public interface TransferenciaRequestToTransferenciaMapper {
    Transferencia toTransferencia(final TransferenciaRequest transferenciaRequest);
}