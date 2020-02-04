package com.desafio.despesa.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.desafio.despesa.model.Conta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaForm {

	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String nome;

	@NotNull
	private BigDecimal saldoInicial;

	private BigDecimal saldo;

	public Conta converter() {
		return new Conta(nome, saldoInicial, saldo);
	}

}
