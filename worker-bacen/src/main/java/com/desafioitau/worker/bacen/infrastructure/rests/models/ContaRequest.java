package com.desafioitau.worker.bacen.infrastructure.rests.models;

import lombok.Data;

@Data
public class ContaRequest {
    private String idOrigem;
    private String idDestino;
}