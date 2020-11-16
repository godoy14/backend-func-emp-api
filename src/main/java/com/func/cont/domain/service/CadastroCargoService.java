package com.func.cont.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.func.cont.domain.exception.CargoNaoEncontradoException;
import com.func.cont.domain.exception.EntidadeEmUsoException;
import com.func.cont.domain.model.Cargo;
import com.func.cont.domain.repository.CargoRepository;

@Service
public class CadastroCargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public Cargo salvar(Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	public void excluir(Long cargoId) {
		try {
			cargoRepository.deleteById(cargoId);
		} catch (EmptyResultDataAccessException e) {
			throw new CargoNaoEncontradoException(cargoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Cargo em uso, não pode ser excluido");
		}
		
	}
	
	public Cargo buscarOuFalhar(Long cargoId) {
		return cargoRepository.findById(cargoId).
				orElseThrow(() -> new CargoNaoEncontradoException(cargoId));
	}

}
