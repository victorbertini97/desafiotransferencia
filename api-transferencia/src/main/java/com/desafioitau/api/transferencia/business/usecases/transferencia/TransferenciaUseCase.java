package com.desafioitau.api.transferencia.business.usecases.transferencia;

import static java.lang.String.format;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.desafioitau.api.transferencia.adapters.AtualizarSaldoContaAdapter;
import com.desafioitau.api.transferencia.adapters.NotificarBacenAdapter;
import com.desafioitau.api.transferencia.adapters.ProcurarContaAdapter;
import com.desafioitau.api.transferencia.adapters.RegistrarTransferenciaAdapter;
import com.desafioitau.api.transferencia.business.exceptions.ResourceNotFoundException;
import com.desafioitau.api.transferencia.business.models.Transferencia;
import com.desafioitau.api.transferencia.business.usecases.transferencia.validators.TransferenciaValidator;
import com.desafioitau.api.transferencia.infrastructure.rests.models.ContaResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class TransferenciaUseCase {

    private static final String ERRO_CONTA_NAO_ENCONTRADA = "Conta não encontrada '%s'.";

    private final ProcurarContaAdapter procurarContaAdapter;
    private final Collection<TransferenciaValidator> validators;
    private final AtualizarSaldoContaAdapter atualizarSaldoContaAdapter;
    private final NotificarBacenAdapter notificarBacenAdapter;
    private final RegistrarTransferenciaAdapter registrarTransferenciaAdapter;

    public String transferir(final Transferencia transferencia) {
        final var contaOrigem = carregarContaOrigem(transferencia.getConta().getIdOrigem());
        validarTransferencia(contaOrigem, transferencia);
        atualizarSaldoConta(transferencia);
        notificarBacen(transferencia);
        return registrarTransferencia(transferencia);

    }

    private ContaResponse carregarContaOrigem(final String idOrigem) {
        return procurarContaAdapter.procurarConta(idOrigem)
                .orElseThrow(() -> new ResourceNotFoundException(format(ERRO_CONTA_NAO_ENCONTRADA, idOrigem)));
    }

    private void validarTransferencia(final ContaResponse contaOrigem, final Transferencia transferencia) {
        validators.forEach(validator -> validator.validar(contaOrigem, transferencia));
    }

    private void atualizarSaldoConta(final Transferencia transferencia) {
        atualizarSaldoContaAdapter.atualizarSaldoConta(transferencia);
    }

    private void notificarBacen(final Transferencia transferencia) {
        notificarBacenAdapter.notificarBacen(transferencia);
    }

    private String registrarTransferencia(final Transferencia transferencia) {
        return registrarTransferenciaAdapter.registrarTransferencia(transferencia);
    }

}