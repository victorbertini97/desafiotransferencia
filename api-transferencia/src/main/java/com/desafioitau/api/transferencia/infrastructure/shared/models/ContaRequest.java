package com.desafioitau.api.transferencia.infrastructure.shared.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContaRequest {

    @NotBlank(message = "Identificador da conta origem é obrigatório.")
    private String idOrigem;

    @NotBlank(message = "Identificador da conta destino é obrigatório.")
    private String idDestino;

}