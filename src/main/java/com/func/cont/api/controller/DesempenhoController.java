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

import com.func.cont.domain.model.Desempenho;
import com.func.cont.domain.repository.DesempenhoRepository;
import com.func.cont.domain.service.CadastroDesempenhoService;

@RestController
@RequestMapping("/desempenhos")
@CrossOrigin
public class DesempenhoController {
	
	@Autowired
	DesempenhoRepository desempenhoRepository;
	
	@Autowired
	CadastroDesempenhoService cadastroDesempenhoService;
	
	@GetMapping
	public List<Desempenho> listar() {
		
		return desempenhoRepository.findAll();
	}
	
	@GetMapping("/{desempenhoId}")
	public Desempenho buscar(@PathVariable Long desempenhoId) {
		
		return cadastroDesempenhoService.buscarOuFalhar(desempenhoId);
	}
	
	@GetMapping("/por-funcionario")
	public List<Desempenho> desempenhoPorFuncionario(Long funcionarioId) {
		return desempenhoRepository.consultarPorFuncionarioId(funcionarioId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Desempenho adicionar(@RequestBody Desempenho desempenho) {
		
		return cadastroDesempenhoService.salvar(desempenho);
	}
	
	@PutMapping("/{desempenhoId}")
	public Desempenho atualizar(
			@PathVariable Long desempenhoId,
			@RequestBody Desempenho desempenho) {
		
		Desempenho desempenhoAtual = cadastroDesempenhoService.buscarOuFalhar(desempenhoId);
		
		BeanUtils.copyProperties(desempenho, desempenhoAtual, "id");
		
		return cadastroDesempenhoService.salvar(desempenhoAtual);
	}
	
	@DeleteMapping("/{desempenhoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long desempenhoId) {
		cadastroDesempenhoService.excluir(desempenhoId);
	}
	
	
	
}
