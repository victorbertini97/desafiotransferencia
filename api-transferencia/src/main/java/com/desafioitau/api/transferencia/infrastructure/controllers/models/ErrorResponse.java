package com.desafioitau.api.transferencia.infrastructure.controllers.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private Integer statusCode;
    private Date timestamp;
    private String message;
}