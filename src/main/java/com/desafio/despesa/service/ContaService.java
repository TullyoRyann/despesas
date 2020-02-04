package com.desafio.despesa.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.despesa.form.ContaForm;
import com.desafio.despesa.model.Conta;
import com.desafio.despesa.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public Conta cadastrar(ContaForm form) {
		form.setSaldo(form.getSaldoInicial());
		Conta conta = form.converter();
		return salvar(conta);
	}

	public Conta get(Long id) {
		Optional<Conta> optional = contaRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	public Conta salvar(Conta conta) {
		return contaRepository.save(conta);
	}

	public void debitar(Conta conta, BigDecimal valor) {
		BigDecimal novoSaldo = conta.getSaldo().subtract(valor);
		conta.setSaldo(novoSaldo);
	}

	public void creditar(Conta conta, BigDecimal valor) {
		BigDecimal novoSaldo = conta.getSaldo().add(valor);
		conta.setSaldo(novoSaldo);
	}

	public BigDecimal getSaldoTotal() {
		BigDecimal somarSaldoTotal = contaRepository.somarSaldoTotal();
		return somarSaldoTotal;
	}

}
