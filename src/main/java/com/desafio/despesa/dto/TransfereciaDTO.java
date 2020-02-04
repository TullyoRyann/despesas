package com.desafio.despesa.dto;

import java.math.BigDecimal;

import com.desafio.despesa.model.Transferencia;

import lombok.Getter;

@Getter
public class TransfereciaDTO {

	private String origem;
	private String destino;
	private BigDecimal valor;

	public TransfereciaDTO(Transferencia transferencia) {
		this.origem = transferencia.getOrigem().getNome();
		this.destino = transferencia.getDestino().getNome();
		this.valor = transferencia.getValor();
	}
}
