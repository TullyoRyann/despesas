package com.desafio.despesa.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class TransfereciaForm {

	@NotNull
	private Long idOrigem;
	@NotNull
	private Long idDestino;
	@NotNull
	private BigDecimal valor;

}
