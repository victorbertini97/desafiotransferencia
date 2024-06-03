package com.desafioitau.api.transferencia.infrastructure.rests.facade;

import org.springframework.stereotype.Component;

import com.desafioitau.api.transferencia.adapters.ProcurarClienteAdapter;
import com.desafioitau.api.transferencia.infrastructure.rests.ClientesRest;

import feign.FeignException;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class ProcurarClienteRestFacade implements ProcurarClienteAdapter {

    private static final String LOG_ERRO_PROCURAR_CLIENTE = "#error ao procurar o cliente '{}'.";

    private final ClientesRest clientesRest;

    @Override
    public boolean procurarCliente(@NotBlank final String idCliente) {
        try {
            return clientesRest.procurarCliente(idCliente).isPresent();
        } catch(FeignException.NotFound e) {
            log.error(LOG_ERRO_PROCURAR_CLIENTE, idCliente, e);
            return false;
        }
    }

}