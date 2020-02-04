package com.desafio.despesa.exception;

import lombok.Getter;

@Getter
public class ContaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Long id;

	public ContaNotFoundException(Long id) {
		super("Conta não existe: " + id);
	}

	public ContaNotFoundException(String msg, Long id) {
		super(msg + id);
	}

}
