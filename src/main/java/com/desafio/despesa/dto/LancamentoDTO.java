package com.desafio.despesa.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.desafio.despesa.model.Lancamento;

import lombok.Getter;

@Getter
public class LancamentoDTO {

	private Long id;
	private String descricao;
	private BigDecimal valor;
	private String tipo;
	private String nomeConta;

	public LancamentoDTO(Lancamento lancamento) {
		this.id = lancamento.getId();
		this.descricao = lancamento.getDescricao();
		this.valor = lancamento.getValor();
		this.tipo = lancamento.getTipo().getTipo();
		this.nomeConta = lancamento.getConta().getNome();
	}

	public static List<LancamentoDTO> converter(List<Lancamento> movimentacoes) {
		return movimentacoes.stream().map(LancamentoDTO::new).collect(Collectors.toList());
	}

}
