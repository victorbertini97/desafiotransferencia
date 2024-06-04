package com.desafioitau.api.transferencia.infrastructure.rests;

import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;
import com.desafioitau.api.transferencia.infrastructure.rests.models.TransferenciaRequest;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "ContasRest", url = "${rests.contas.url}")
public interface ContasRest {

    @PutMapping(value = "/contas/saldos")
    void atualizarSaldoConta(@RequestBody final TransferenciaRequest transferenciaRequest);

    @GetMapping(value = "/contas/{idConta}")
    @Retryable(noRetryFor = { FeignException.NotFound.class })
    Optional<ContaResponse> procurarConta(@PathVariable("idConta") final String idCliente);

}
