package com.desafio.despesa.presentation.assembler;

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

}
