package com.desafio.despesa.exception;

public class ContaBalanceBeingInsufficientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContaBalanceBeingInsufficientException() {
		super("Saldo insuficiente");
	}

}
