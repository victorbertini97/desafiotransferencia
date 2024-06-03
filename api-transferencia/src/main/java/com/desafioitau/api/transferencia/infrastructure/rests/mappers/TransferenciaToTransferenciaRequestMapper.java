package com.desafioitau.api.transferencia.infrastructure.rests.mappers;

import org.mapstruct.Mapper;

import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.infrastructure.rests.models.TransferenciaRequest;

@Mapper(componentModel = "spring")
public interface TransferenciaToTransferenciaRequestMapper {
    TransferenciaRequest toTransferenciaRequest(final Transferencia transferencia);
}