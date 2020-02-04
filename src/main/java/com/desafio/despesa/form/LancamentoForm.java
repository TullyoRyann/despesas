package com.desafio.despesa.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.desafio.despesa.exception.ContaNotFoundException;
import com.desafio.despesa.model.Conta;
import com.desafio.despesa.model.Lancamento;
import com.desafio.despesa.service.ContaService;
import com.desafio.despesa.type.TipoLancamento;

import lombok.Getter;

@Getter
public class LancamentoForm {

	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String descricao;

	@NotNull
	private BigDecimal valor;

	@NotNull
	private TipoLancamento tipo;

	@NotNull
	private Long idConta;

	public Lancamento converter(ContaService contaService) {
		Conta conta = contaService.get(idConta);
		if (conta == null) {
			throw new ContaNotFoundException(idConta);
		}
		return new Lancamento(descricao, valor, tipo, conta);
	}

}
