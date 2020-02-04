package com.desafio.despesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.despesa.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
