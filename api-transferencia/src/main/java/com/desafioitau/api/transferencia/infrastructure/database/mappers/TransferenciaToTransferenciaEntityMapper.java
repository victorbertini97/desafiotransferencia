package com.desafioitau.api.transferencia.infrastructure.database.mappers;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.infrastructure.database.models.TransferenciaEntity;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface TransferenciaToTransferenciaEntityMapper {
    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    TransferenciaEntity toTransferenciaEntity(final Transferencia transferencia);
}