package com.desafioitau.api.transferencia.infrastructure.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafioitau.api.transferencia.infrastructure.database.models.TransferenciaEntity;

@SpringBootTest
class TransferenciaRepositoryTest {

    @Autowired private TransferenciaRepository transferenciaRepository;

    @Test
    void dadoSave_quandoChamado_entaoRegistraTransferencia() {
        //Dado:
        final var transferencia = new EasyRandom().nextObject(TransferenciaEntity.class);

        //Quando:
        transferenciaRepository.save(transferencia);

        //Entao:
        final var registroTransferencia = transferenciaRepository.findById(transferencia.getId());
        assertEquals(registroTransferencia.get(), transferencia);

    }

}