package com.desafioitau.worker.bacen.infrastructure.rests.mappers;

import org.mapstruct.Mapper;

import com.desafioitau.worker.bacen.business.dominio.Transferencia;
import com.desafioitau.worker.bacen.infrastructure.rests.models.NotificacaoRequest;

@Mapper(componentModel = "spring")
public interface TransferenciaToNotificacaoRequestMapper {
	 NotificacaoRequest toNotificacaoRequest(final Transferencia transferencia);
}