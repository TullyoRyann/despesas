package com.desafio.despesa.controller;

import java.math.BigDecimal;
import java.net.URI;

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

import com.desafio.despesa.dto.ContaDTO;
import com.desafio.despesa.form.ContaForm;
import com.desafio.despesa.model.Conta;
import com.desafio.despesa.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@PostMapping
	public ResponseEntity<ContaDTO> cadastrar(@RequestBody @Valid ContaForm form, UriComponentsBuilder uriBuilder) {
		Conta conta = contaService.cadastrar(form);
		URI uri = uriBuilder.path("/contas/{id}").buildAndExpand(conta.getId()).toUri();
		return ResponseEntity.created(uri).body(new ContaDTO(conta));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaDTO> get(@PathVariable Long id) {
		Conta conta = contaService.get(id);
		return conta != null ? ResponseEntity.ok(new ContaDTO(conta)) : ResponseEntity.notFound().build();
	}

	@GetMapping("/saldoTotal")
	public ResponseEntity<BigDecimal> getSaldoAtual() {
		BigDecimal saldoTotal = contaService.getSaldoTotal();
		return ResponseEntity.ok(saldoTotal);
	}

}
