package com.desafio.despesa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.despesa.dto.LancamentoDTO;
import com.desafio.despesa.exception.ContaNotFoundException;
import com.desafio.despesa.form.LancamentoForm;
import com.desafio.despesa.infrastructure.service.ResponseService;
import com.desafio.despesa.model.Conta;
import com.desafio.despesa.model.Lancamento;
import com.desafio.despesa.presentation.assembler.LancamentoAssembler;
import com.desafio.despesa.presentation.dto.shared.ResponseTO;
import com.desafio.despesa.service.ContaService;
import com.desafio.despesa.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	@Autowired
	private ContaService contaService;

	@Autowired
	private ResponseService responseService;

	@PostMapping
	public ResponseEntity<ResponseTO<LancamentoDTO>> cadastrar(@RequestBody @Valid LancamentoForm form, UriComponentsBuilder uriBuilder) {
		Conta conta = contaService.get(form.getIdConta());
		if (conta == null) {
			throw new ContaNotFoundException(form.getIdConta());
		}
		Lancamento lancamento = LancamentoAssembler.from(form, conta);
		lancamentoService.cadastrar(lancamento);
		return responseService.create(LancamentoAssembler.from(lancamento), uriBuilder, lancamento.getId(), "/lancamentos/{id}");
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseTO<LancamentoDTO>> get(@PathVariable Long id) {
		Lancamento lancamento = lancamentoService.get(id);
		return lancamento != null ? responseService.ok(LancamentoAssembler.from(lancamento)) : responseService.notFound();
	}

	@GetMapping("/movimentacoes")
	public ResponseEntity<ResponseTO<List<LancamentoDTO>>> getMovimentacoes() {
		return responseService.ok(LancamentoAssembler.from(lancamentoService.getMovimentacoes()));
	}

}
