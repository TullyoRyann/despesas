package com.desafio.despesa.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContaDTO {

	private Long id;
	private String nome;
	private BigDecimal saldoInicial;
	private BigDecimal saldo;
}
