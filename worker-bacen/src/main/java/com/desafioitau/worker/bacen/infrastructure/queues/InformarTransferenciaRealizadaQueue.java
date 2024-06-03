package com.desafioitau.worker.bacen.infrastructure.queues;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import com.desafioitau.worker.bacen.adapters.InformarTransferenciaRealizadaAdapter;
import com.desafioitau.worker.bacen.business.dominio.Transferencia;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class InformarTransferenciaRealizadaQueue implements InformarTransferenciaRealizadaAdapter {

    private static final String SQS_TRANSFERENCIA_REALIZADA = "sqs-transferencia-realizada";

    private final SqsTemplate sqsTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void informarTransferenciaRealizada(@NotNull final Transferencia transferencia) {
        sqsTemplate.send(to -> to.queue(SQS_TRANSFERENCIA_REALIZADA).payload(toJson(transferencia)));
    }

    @SneakyThrows
    private String toJson(final Transferencia transferencia) {
        return objectMapper.writeValueAsString(transferencia);
    }

}