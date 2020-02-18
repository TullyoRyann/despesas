package com.desafio.despesa.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LancamentoDTO {

	private Long id;
	private String descricao;
	private BigDecimal valor;
	private String tipo;
	private String nomeConta;

}
