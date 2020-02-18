package com.desafio.despesa.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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

}
