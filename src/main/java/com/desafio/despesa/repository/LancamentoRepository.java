package com.desafio.despesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.despesa.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
