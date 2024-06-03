package com.desafioitau.api.transferencia.infrastructure.database.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TransferenciaEntity {
    @Id
    private String id;
    private String idCliente;
    private Double valor;
    @Embedded
    private ContaEntity conta;
}