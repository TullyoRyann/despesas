package com.desafio.despesa.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.despesa.exception.ContaBalanceBeingInsufficientException;
import com.desafio.despesa.exception.ContaNotFoundException;
import com.desafio.despesa.form.TransfereciaForm;
import com.desafio.despesa.model.Conta;
import com.desafio.despesa.model.Transferencia;
import com.desafio.despesa.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transfRepository;

	@Autowired
	private ContaService contaService;

	public Transferencia addTransferencia(TransfereciaForm transfDTO) {
		Conta origem = contaService.get(transfDTO.getIdOrigem());
		if (origem == null) {
			throw new ContaNotFoundException("Conta de origem não existe, id: ", transfDTO.getIdOrigem());
		}

		Conta destino = contaService.get(transfDTO.getIdDestino());
		if (destino == null) {
			throw new ContaNotFoundException("Conta de destino não existe, id: ", transfDTO.getIdDestino());
		}

		BigDecimal valor = transfDTO.getValor();
		if (origem.getSaldo().compareTo(valor) < 0) {
			throw new ContaBalanceBeingInsufficientException();
		}
		return transferir(origem, destino, valor);
	}

	private Transferencia transferir(Conta origem, Conta destino, BigDecimal valor) {
		contaService.debitar(origem, valor);
		contaService.creditar(destino, valor);
		contaService.salvar(origem);
		contaService.salvar(destino);
		Transferencia transferencia = new Transferencia(origem, destino, valor);
		return transfRepository.save(transferencia);
	}

	public Transferencia get(Long id) {
		Optional<Transferencia> optional = transfRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

}
