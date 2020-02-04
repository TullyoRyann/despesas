package com.desafio.despesa.controller;

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

import com.desafio.despesa.dto.TransfereciaDTO;
import com.desafio.despesa.form.TransfereciaForm;
import com.desafio.despesa.model.Transferencia;
import com.desafio.despesa.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transfService;

	@PostMapping
	public ResponseEntity<TransfereciaDTO> addTransferencia(@RequestBody @Valid TransfereciaForm form, UriComponentsBuilder uriBuilder) {
		Transferencia transferencia = transfService.addTransferencia(form);
		URI uri = uriBuilder.path("/transferencias/{id}").buildAndExpand(transferencia.getId()).toUri();
		return ResponseEntity.created(uri).body(new TransfereciaDTO(transferencia));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransfereciaDTO> get(@PathVariable Long id) {
		Transferencia transferencia = transfService.get(id);
		return transferencia != null ? ResponseEntity.ok(new TransfereciaDTO(transferencia)) : ResponseEntity.notFound().build();
	}

}
