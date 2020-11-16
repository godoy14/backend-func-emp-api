package com.func.cont.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.func.cont.domain.exception.DesempenhoNaoEncontradoException;
import com.func.cont.domain.model.Desempenho;
import com.func.cont.domain.repository.DesempenhoRepository;

@Service
public class CadastroDesempenhoService {

	@Autowired
	private DesempenhoRepository desempenhoRepository;
	
	public Desempenho salvar(Desempenho desempenho) {
		return desempenhoRepository.save(desempenho);
	}
	
	public void excluir(Long desempenhoId) {
		try {
			desempenhoRepository.deleteById(desempenhoId);
		} catch (EmptyResultDataAccessException e) {
			throw new DesempenhoNaoEncontradoException(desempenhoId);
		}
	}
	
	public Desempenho buscarOuFalhar(Long desempenhoId) {
		return desempenhoRepository.findById(desempenhoId)
				.orElseThrow(() -> new DesempenhoNaoEncontradoException(desempenhoId));
	}
	
}
