package com.desafio.despesa.controller;

import java.math.BigDecimal;

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
import com.desafio.despesa.infrastructure.service.ResponseService;
import com.desafio.despesa.model.Conta;
import com.desafio.despesa.presentation.assembler.ContaAssembler;
import com.desafio.despesa.presentation.dto.shared.ResponseTO;
import com.desafio.despesa.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@Autowired
	private ResponseService responseService;

	@PostMapping
	public ResponseEntity<ResponseTO<ContaDTO>> cadastrar(@RequestBody @Valid ContaForm form, UriComponentsBuilder uriBuilder) {
		Conta conta = ContaAssembler.from(form);
		contaService.cadastrar(conta);
		return responseService.create(ContaAssembler.from(conta), uriBuilder, conta.getId(), "/contas/{id}");
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseTO<ContaDTO>> get(@PathVariable Long id) {
		Conta conta = contaService.get(id);
		return conta != null ? responseService.ok(ContaAssembler.from(conta)) : responseService.notFound();
	}

	@GetMapping("/saldoTotal")
	public ResponseEntity<ResponseTO<BigDecimal>> getSaldoAtual() {
		return responseService.ok(contaService.getSaldoTotal());
	}

}
