package com.desafioitau.api.transferencia.infrastructure.rests;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafioitau.api.transferencia.infrastructure.rests.models.ClienteResponse;

import feign.FeignException;

@FeignClient(name = "ClientesClient", url = "${rests.clientes.url}")
public interface ClientesRest {

    @GetMapping(value = "/clientes/{idCliente}")
    @Retryable(noRetryFor = { FeignException.NotFound.class })
    Optional<ClienteResponse> procurarCliente(@PathVariable("idCliente") final String idCliente);

}