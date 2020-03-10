package com.desafio.despesa.presentation.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.desafio.despesa.dto.ContaDTO;
import com.desafio.despesa.form.ContaForm;
import com.desafio.despesa.model.Conta;

public class ContaAssembler {

	public static Conta from(ContaForm form) {
		return new Conta(form.getNome(), form.getSaldoInicial(), form.getSaldo());
	}

	public static ContaDTO from(Conta conta) {
		return new ContaDTO(conta.getId(), conta.getNome(), conta.getSaldoInicial(), conta.getSaldo());
	}

	public static List<ContaDTO> from(List<Conta> contas) {
		return contas.stream().map(ContaAssembler::from).collect(Collectors.toList());
	}

	public static Page<ContaDTO> from(Page<Conta> contas) {
		return contas.map(ContaAssembler::from);
	}

}
