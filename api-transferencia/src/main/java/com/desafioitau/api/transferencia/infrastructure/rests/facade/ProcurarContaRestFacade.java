package com.desafioitau.api.transferencia.infrastructure.rests.facade;

import com.desafioitau.api.transferencia.adapters.ProcurarContaAdapter;
import com.desafioitau.api.transferencia.infrastructure.rests.ContasRest;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;
import feign.FeignException;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Optional.empty;

@Slf4j
@Component
@AllArgsConstructor
public class ProcurarContaRestFacade implements ProcurarContaAdapter {

    private static final String LOG_ERRO_PROCURAR_CONTA = "#error ao procurar a conta '{}'.";

    private final ContasRest contasRest;

    @Override
    public Optional<ContaResponse> procurarConta(@NotBlank final String idConta) {
        try {
            return contasRest.procurarConta(idConta);
        } catch(FeignException.NotFound e) {
            log.error(LOG_ERRO_PROCURAR_CONTA, idConta, e);
            return empty();
        }
    }

}