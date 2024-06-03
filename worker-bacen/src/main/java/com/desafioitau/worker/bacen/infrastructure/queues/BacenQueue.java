package com.desafioitau.worker.bacen.infrastructure.queues;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement;
import org.springframework.stereotype.Component;

import com.desafioitau.worker.bacen.business.dominio.Transferencia;
import com.desafioitau.worker.bacen.business.usecases.notificarbacen.NotificarBacenUseCase;
import software.amazon.awssdk.services.sqs.model.Message;

import io.awspring.cloud.sqs.annotation.SqsListener;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
@Component
public class BacenQueue {

    private final NotificarBacenUseCase notificarBacenUseCase;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @SqsListener(value = "sqs-bacen-notificacao", acknowledgementMode = "MANUAL")
    public void notificarBacen(@NotNull final Message message, Acknowledgement acknowledgement) {
        notificarBacenUseCase.notificarBacen(objectMapper.readValue(message.body(), Transferencia.class));
        acknowledgement.acknowledge();
    }

}