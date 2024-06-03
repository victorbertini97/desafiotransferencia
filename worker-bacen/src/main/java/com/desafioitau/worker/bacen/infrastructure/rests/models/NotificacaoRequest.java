package com.desafioitau.worker.bacen.infrastructure.rests.models;

import lombok.Data;

@Data
public class NotificacaoRequest {
    private Double valor;
    private ContaRequest conta;
}