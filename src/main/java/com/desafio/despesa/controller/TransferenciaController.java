package com.desafio.despesa.controller;

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

import com.desafio.despesa.dto.TransferenciaDTO;
import com.desafio.despesa.form.TransferenciaForm;
import com.desafio.despesa.infrastructure.service.ResponseService;
import com.desafio.despesa.model.Transferencia;
import com.desafio.despesa.presentation.assembler.TransferenciaAssembler;
import com.desafio.despesa.presentation.dto.shared.ResponseTO;
import com.desafio.despesa.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transfService;

	@Autowired
	private ResponseService responseService;

	@PostMapping
	public ResponseEntity<ResponseTO<TransferenciaDTO>> addTransferencia(@RequestBody @Valid TransferenciaForm form, UriComponentsBuilder uriBuilder) {
		Transferencia transferencia = transfService.addTransferencia(form);
		return responseService.create(TransferenciaAssembler.from(transferencia), uriBuilder, transferencia.getId(), "/transferencias/{id}");
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseTO<TransferenciaDTO>> get(@PathVariable Long id) {
		Transferencia transferencia = transfService.get(id);
		return transferencia != null ? responseService.ok(TransferenciaAssembler.from(transferencia)) : responseService.notFound();
	}

}
