package com.desafioitau.api.transferencia.business.models;

import lombok.Data;

@Data
public class Transferencia {
    private String idCliente;
    private Double valor;
    private Conta conta;
}