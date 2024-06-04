package com.desafioitau.worker.bacen.infrastructure.rests;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.desafioitau.worker.bacen.infrastructure.rests.models.NotificacaoRequest;

@FeignClient(name = "BacenRest", url = "${rests.bacen.url}")
public interface BacenRest {

    @PostMapping(value = "/notificacoes")
    void notificarBacen(@RequestBody final NotificacaoRequest notificacaoRequest);

}
