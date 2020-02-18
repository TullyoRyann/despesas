package com.desafio.despesa.infrastructure.service;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.despesa.presentation.dto.shared.ResponseTO;

@Service
public class ResponseService {

	public <T> ResponseEntity<ResponseTO<T>> create(T data, UriComponentsBuilder uriBuilder, Long id, String path) {
		URI uri = uriBuilder.path(path).buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).body(new ResponseTO<T>(data));
	}

	public <T> ResponseEntity<ResponseTO<T>> ok(T data) {
		return ResponseEntity.ok(new ResponseTO<T>(data));
	}

	public <T> ResponseEntity<T> notFound() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
