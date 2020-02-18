package com.desafio.despesa.presentation.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.desafio.despesa.dto.LancamentoDTO;
import com.desafio.despesa.form.LancamentoForm;
import com.desafio.despesa.model.Conta;
import com.desafio.despesa.model.Lancamento;

public class LancamentoAssembler {

	public static Lancamento from(LancamentoForm form, Conta conta) {
		return new Lancamento(form.getDescricao(), form.getValor(), form.getTipo(), conta);
	}

	public static LancamentoDTO from(Lancamento lancamento) {
		return new LancamentoDTO(lancamento.getId(), lancamento.getDescricao(), lancamento.getValor(), lancamento.getTipo().getTipo(), lancamento.getConta().getNome());
	}

	public static List<LancamentoDTO> from(List<Lancamento> lancamentos) {
		return lancamentos.stream().map(LancamentoAssembler::from).collect(Collectors.toList());
	}

}
