package com.desafio.despesa.type;

public enum TipoLancamento {

	RECEITA("1"), DESPESA("2");

	private String tipo;

	public String getTipo() {
		return this.tipo;
	}

	private TipoLancamento(String tipo) {
		this.tipo = tipo;
	}
}
