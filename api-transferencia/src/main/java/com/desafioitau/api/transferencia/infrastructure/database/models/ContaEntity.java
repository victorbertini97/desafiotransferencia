package com.desafioitau.api.transferencia.infrastructure.database.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ContaEntity {
    private String idOrigem;
    private String idDestino;
}