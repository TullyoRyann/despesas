package com.desafio.despesa.presentation.assembler;

import com.desafio.despesa.dto.TransferenciaDTO;
import com.desafio.despesa.model.Transferencia;

public class TransferenciaAssembler {

	public static TransferenciaDTO from(Transferencia transferencia) {
		return new TransferenciaDTO(transferencia.getOrigem().getNome(), transferencia.getDestino().getNome(), transferencia.getValor());
	}

}
