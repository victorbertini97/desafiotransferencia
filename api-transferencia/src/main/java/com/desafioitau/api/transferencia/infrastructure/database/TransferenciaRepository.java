package com.desafioitau.api.transferencia.infrastructure.database;

import org.springframework.data.repository.CrudRepository;

import com.desafioitau.api.transferencia.infrastructure.database.models.TransferenciaEntity;

public interface TransferenciaRepository extends CrudRepository<TransferenciaEntity, String> {}