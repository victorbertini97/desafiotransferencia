package com.desafioitau.api.transferencia.infrastructure.controllers.models;

import com.desafioitau.api.transferencia.infrastructure.shared.models.ContaRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferenciaRequest {

    @NotBlank(message = "Identificador do cliente é obrigatório.")
    private String idCliente;

    @Valid
    @NotNull(message = "Informações da conta são obrigatórios.")
    private ContaRequest conta;

    @NotNull(message = "Valor da transferência é obrigatório.")
    private Double valor;

}