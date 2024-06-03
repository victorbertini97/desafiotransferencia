package com.desafioitau.api.transferencia.infrastructure.controllers.handlers;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.http.ResponseEntity.unprocessableEntity;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafioitau.api.transferencia.business.exceptions.ResourceNotFoundException;
import com.desafioitau.api.transferencia.business.exceptions.ValidationException;
import com.desafioitau.api.transferencia.infrastructure.controllers.models.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(final MethodArgumentNotValidException e) {
        final var errorResponse = new ErrorResponse(BAD_REQUEST.value(), new Date(), e.getAllErrors().get(0).getDefaultMessage());
        return badRequest().body(errorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(final ResourceNotFoundException e) {
        final var errorResponse = new ErrorResponse(NOT_FOUND.value(), new Date(), e.getMessage());
        return status(NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> validationException(final ValidationException e) {
        final var errorResponse = new ErrorResponse(UNPROCESSABLE_ENTITY.value(), new Date(), e.getMessage());
        return unprocessableEntity().body(errorResponse);
    }

}