package com.desafio.despesa.controller;

import java.net.URI;
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
import com.desafio.despesa.form.LancamentoForm;
import com.desafio.despesa.model.Lancamento;
import com.desafio.despesa.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	@PostMapping
	public ResponseEntity<LancamentoDTO> cadastrar(@RequestBody @Valid LancamentoForm form, UriComponentsBuilder uriBuilder) {
		Lancamento lancamento = lancamentoService.cadastrar(form);
		URI uri = uriBuilder.path("/lancamentos/{id}").buildAndExpand(lancamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new LancamentoDTO(lancamento));
	}

	@GetMapping("/{id}")
	public ResponseEntity<LancamentoDTO> get(@PathVariable Long id) {
		Lancamento lancamento = lancamentoService.get(id);
		return lancamento != null ? ResponseEntity.ok(new LancamentoDTO(lancamento)) : ResponseEntity.notFound().build();
	}

	@GetMapping("/movimentacoes")
	public List<LancamentoDTO> getMovimentacoes() {
		List<Lancamento> movimentacoes = lancamentoService.getMovimentacoes();
		return LancamentoDTO.converter(movimentacoes);
	}

}
