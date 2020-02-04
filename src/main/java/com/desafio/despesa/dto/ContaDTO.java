package com.desafio.despesa.dto;

import java.math.BigDecimal;

import com.desafio.despesa.model.Conta;

import lombok.Getter;

@Getter
public class ContaDTO {

	private Long id;
	private String nome;
	private BigDecimal saldoInicial;
	private BigDecimal saldo;

	public ContaDTO(Conta conta) {
		this.id = conta.getId();
		this.nome = conta.getNome();
		this.saldoInicial = conta.getSaldoInicial();
		this.saldo = conta.getSaldo();
	}
}
