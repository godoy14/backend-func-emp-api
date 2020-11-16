package com.func.cont.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.func.cont.domain.exception.EntidadeEmUsoException;
import com.func.cont.domain.exception.FuncionarioNaoEncontradoException;
import com.func.cont.domain.model.Cargo;
import com.func.cont.domain.model.Funcionario;
import com.func.cont.domain.repository.FuncionarioRepository;

@Service
public class CadastroFuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private CadastroCargoService cadastroCargoService;
	
	public Funcionario salvar(Funcionario funcionario) {
		Long cargoId = funcionario.getCargo().getId();
		
		Cargo cargo = cadastroCargoService.buscarOuFalhar(cargoId);
		
		funcionario.setCargo(cargo);
		
		return funcionarioRepository.save(funcionario);
		
	}
	
	public void excluir(Long funcionarioId) {
		try {
			funcionarioRepository.deleteById(funcionarioId);
		} catch (EmptyResultDataAccessException e) {
			throw new FuncionarioNaoEncontradoException(funcionarioId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Funcionario em uso, não pode ser exlcuido.");
		}
	}
	
	public Funcionario buscarOuFalhar(Long funcionarioId) {
		return funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new FuncionarioNaoEncontradoException(funcionarioId));
	}
}
