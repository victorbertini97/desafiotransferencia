package com.desafioitau.api.transferencia.infrastructure.database.facade;

import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.infrastructure.database.TransferenciaRepository;
import com.desafioitau.api.transferencia.infrastructure.database.mappers.TransferenciaToTransferenciaEntityMapper;
import com.desafioitau.api.transferencia.infrastructure.database.models.TransferenciaEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrarTransferenciaDatabaseFacadeTest {

    @Mock private TransferenciaToTransferenciaEntityMapper toTransferenciaEntityMapper;
    @Mock  private TransferenciaRepository transferenciaRepository;
    @InjectMocks private RegistrarTransferenciaDatabaseFacade registrarTransferenciaDatabaseFacade;

    @Test
    void dadoRegistrarTransferencia_quandoChamado_entaoGravaBancoDados() {
        //Dado:
        final var transferencia = mock(Transferencia.class);
        final TransferenciaEntity transferenciaEntity = when(mock(TransferenciaEntity.class).getId()).thenReturn(randomUUID().toString()).getMock();

        when(toTransferenciaEntityMapper.toTransferenciaEntity(transferencia)).thenReturn(transferenciaEntity);
        when(transferenciaRepository.save(transferenciaEntity)).thenReturn(transferenciaEntity);

        //Quando:
        final var idTransferencia = registrarTransferenciaDatabaseFacade.registrarTransferencia(transferencia);

        //Entao:
        assertEquals(transferenciaEntity.getId(), idTransferencia);

    }

}