package com.func.cont.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.func.cont.domain.exception.CargoNaoEncontradoException;
import com.func.cont.domain.model.Funcionario;
import com.func.cont.domain.repository.FuncionarioRepository;
import com.func.cont.domain.service.CadastroFuncionarioService;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private CadastroFuncionarioService cadastroFuncionarioService;
	
	@GetMapping
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/{funcionarioId}")
	public Funcionario buscar(@PathVariable Long funcionarioId) {
		return cadastroFuncionarioService.buscarOuFalhar(funcionarioId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario adicionar(@RequestBody Funcionario funcionario) {
		try {
			return cadastroFuncionarioService.salvar(funcionario);
		} catch (CargoNaoEncontradoException e) {
			throw new CargoNaoEncontradoException("Cargo relacionado não encontrado.");
		}
	}
	
	@PutMapping("/{funcionarioId}")
	public Funcionario atualizar(
			@PathVariable Long funcionarioId, 
			@RequestBody Funcionario funcionario) {
		
		Funcionario funcionarioAtual = cadastroFuncionarioService.buscarOuFalhar(funcionarioId);
		
		BeanUtils.copyProperties(funcionario, funcionarioAtual, "id");
		
		try {
			return cadastroFuncionarioService.salvar(funcionarioAtual);
		} catch (CargoNaoEncontradoException e) {
			throw new CargoNaoEncontradoException("Cargo relacionado não encontrado.");
		}
	}
	
	@DeleteMapping("/{funcionarioId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long funcionarioId) {
		cadastroFuncionarioService.excluir(funcionarioId);
	}

}
