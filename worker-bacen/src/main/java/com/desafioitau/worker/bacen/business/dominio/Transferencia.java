package com.desafioitau.worker.bacen.business.dominio;

import lombok.Data;

@Data
public class Transferencia {
    private String idCliente;
    private Double valor;
    private Conta conta;
}