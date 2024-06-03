package com.desafioitau.api.transferencia.business.exceptions;

@SuppressWarnings("serial")
public class ValidationException extends RuntimeException {
    public ValidationException(final String message) {
        super(message);
    }
}