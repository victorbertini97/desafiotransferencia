package com.desafioitau.api.transferencia.infrastructure.queues;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import org.springframework.stereotype.Component;

import com.desafioitau.api.transferencia.adapters.NotificarBacenAdapter;
import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.fasterxml.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Component
public class BacenQueue implements NotificarBacenAdapter {

    private static final String SQS_BACEN_NOTIFICACAO = "sqs-bacen-notificacao";

    private final SqsTemplate sqsTemplate;
    private ObjectMapper objectMapper;

    @Override
    public void notificarBacen(@NotNull final Transferencia transferencia) {
        sqsTemplate.send(to -> to.queue(SQS_BACEN_NOTIFICACAO).payload(toJson(transferencia)));
    }

    @SneakyThrows
    private String toJson(final Transferencia transferencia) {
        return objectMapper.writeValueAsString(transferencia);
    }

}