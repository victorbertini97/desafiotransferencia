package com.desafioitau.api.transferencia.infrastructure.controllers.mappers;

import com.desafioitau.api.transferencia.infrastructure.controllers.models.TransferenciaRequest;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransferenciaRequestToTransferenciaMapperTest {

    @Autowired
    private TransferenciaRequestToTransferenciaMapper toTransferenciaMapper;

    @Test
    void dadoToTransferenciaEntity_quandoTransferencia_entaoRetornaTransferenciaEntity() {
        // Dado:
        final var transferenciaRequest = new EasyRandom().nextObject(TransferenciaRequest.class);

        // Quando:
        final var transferencia = toTransferenciaMapper.toTransferencia(transferenciaRequest);

        // Entao:
        assertEquals(transferencia.getConta().getIdDestino(), transferenciaRequest.getConta().getIdDestino());
        assertEquals(transferencia.getConta().getIdOrigem(),  transferenciaRequest.getConta().getIdOrigem());
        assertEquals(transferencia.getIdCliente(),            transferenciaRequest.getIdCliente());
        assertEquals(transferencia.getValor(),                transferenciaRequest.getValor());
    }

}