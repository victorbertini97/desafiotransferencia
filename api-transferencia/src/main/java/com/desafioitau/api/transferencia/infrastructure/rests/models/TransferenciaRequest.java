package com.desafioitau.api.transferencia.infrastructure.rests.models;

import com.desafioitau.api.transferencia.infrastructure.shared.models.ContaRequest;

import lombok.Data;

@Data
public class TransferenciaRequest {
    private Double valor;
    private ContaRequest conta;
}