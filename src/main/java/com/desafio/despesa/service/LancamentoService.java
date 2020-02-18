package com.desafio.despesa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.despesa.model.Lancamento;
import com.desafio.despesa.repository.LancamentoRepository;
import com.desafio.despesa.type.TipoLancamento;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private ContaService contaService;

	public Lancamento cadastrar(Lancamento lancamento) {
		lancamentoRepository.save(lancamento);
		creditarOuDebitarPeloTipo(lancamento);
		return lancamento;
	}

	private void creditarOuDebitarPeloTipo(Lancamento lancamento) {
		if (lancamento.getTipo().equals(TipoLancamento.RECEITA)) {
			contaService.creditar(lancamento.getConta(), lancamento.getValor());
		} else {
			contaService.debitar(lancamento.getConta(), lancamento.getValor());
		}
		contaService.salvar(lancamento.getConta());
	}

	public Lancamento get(Long id) {
		Optional<Lancamento> optional = lancamentoRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	public List<Lancamento> getMovimentacoes() {
		return lancamentoRepository.findAll();
	}

}
