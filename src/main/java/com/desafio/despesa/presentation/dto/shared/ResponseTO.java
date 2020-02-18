package com.desafio.despesa.presentation.dto.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ResponseTO<T> implements Serializable {

	private static final long serialVersionUID = -484656760043308067L;

	@NonNull
	private T data;

	private List<String> errors = new ArrayList<>();

}
