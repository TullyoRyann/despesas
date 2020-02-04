package com.desafio.despesa.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.desafio.despesa.exception.ContaBalanceBeingInsufficientException;
import com.desafio.despesa.exception.ContaNotFoundException;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

	@Autowired
	MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDTO> handle(MethodArgumentNotValidException exception) {
		List<ErroFormularioDTO> list = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroFormularioDTO erro = new ErroFormularioDTO(e.getField(), message);
			list.add(erro);
		});

		return list;
	}

	@ExceptionHandler(ContaNotFoundException.class)
	public ResponseEntity<VndErrors> notFoundException(final ContaNotFoundException e) {
		return error(e, HttpStatus.NOT_FOUND, e.getId().toString());
	}

	@ExceptionHandler(ContaBalanceBeingInsufficientException.class)
	public ResponseEntity<VndErrors> notFoundException(final ContaBalanceBeingInsufficientException e) {
		return error(e, HttpStatus.NOT_ACCEPTABLE, "");
	}

	private ResponseEntity<VndErrors> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
		final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
		return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
	}
}
