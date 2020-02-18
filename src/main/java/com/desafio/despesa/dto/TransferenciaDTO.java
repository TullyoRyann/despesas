package com.desafio.despesa.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransferenciaDTO {

	private String origem;
	private String destino;
	private BigDecimal valor;

}
