package com.desafioitau.api.transferencia.infrastructure.rests.models;

import lombok.Data;

@Data
public class ContaResponse {
    private String id;
    private Double saldo;
    private Double limiteDiario;
    private Boolean ativo;
}