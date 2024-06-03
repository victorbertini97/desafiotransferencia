package com.desafioitau.api.transferencia.infrastructure.database.facade;

import org.springframework.stereotype.Component;

import com.desafioitau.api.transferencia.adapters.RegistrarTransferenciaAdapter;
import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.infrastructure.database.TransferenciaRepository;
import com.desafioitau.api.transferencia.infrastructure.database.mappers.TransferenciaToTransferenciaEntityMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class RegistrarTransferenciaDatabaseFacade implements RegistrarTransferenciaAdapter {

    private final TransferenciaToTransferenciaEntityMapper toTransferenciaEntityMapper;
    private final TransferenciaRepository transferenciaRepository;

    @Override
    public String registrarTransferencia(final Transferencia transferencia) {
        final var registroTransferencia = transferenciaRepository.save(toTransferenciaEntityMapper.toTransferenciaEntity(transferencia));
        return registroTransferencia.getId();
    }

}