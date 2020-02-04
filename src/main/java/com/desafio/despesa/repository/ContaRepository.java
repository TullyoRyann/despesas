package com.desafio.despesa.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.desafio.despesa.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	@Query("SELECT SUM(c.saldo) FROM tb_conta c")
	BigDecimal somarSaldoTotal();
}