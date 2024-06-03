package com.desafioitau.api.transferencia.infrastructure.database.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafioitau.api.transferencia.business.models.Transferencia;

@SpringBootTest
class TransferenciaToTransferenciaEntityMapperTest {

    @Autowired private TransferenciaToTransferenciaEntityMapper transferenciaToTransferenciaEntityMapper;

    @Test
    void dadoToTransferenciaEntity_quandoTransferencia_entaoRetornaTransferenciaEntity() {
        // Dado:
        final var transferencia = new EasyRandom().nextObject(Transferencia.class);

        // Quando:
        final var transferenciaEntity = transferenciaToTransferenciaEntityMapper.toTransferenciaEntity(transferencia);

        // Entao:
        assertEquals(transferencia.getConta().getIdDestino(), transferenciaEntity.getConta().getIdDestino());
        assertEquals(transferencia.getConta().getIdOrigem(),  transferenciaEntity.getConta().getIdOrigem());
        assertEquals(transferencia.getIdCliente(),            transferenciaEntity.getIdCliente());
        assertEquals(transferencia.getValor(),                transferenciaEntity.getValor());
    }
}