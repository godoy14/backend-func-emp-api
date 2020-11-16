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

import com.func.cont.domain.model.Cargo;
import com.func.cont.domain.repository.CargoRepository;
import com.func.cont.domain.service.CadastroCargoService;

@RestController
@RequestMapping("/cargos")
@CrossOrigin
public class CargoController {
	
	@Autowired
	CargoRepository cargoRepository;

	@Autowired
	CadastroCargoService cadastroCargoService;
	
	@GetMapping
	public List<Cargo> listar() {
		
		return cargoRepository.findAll();
	}
	
	@GetMapping("/{cargoId}")
	public Cargo buscar(@PathVariable Long cargoId) {
		
		return cadastroCargoService.buscarOuFalhar(cargoId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cargo adicionar(@RequestBody Cargo cargo) {
		
		return cadastroCargoService.salvar(cargo);
	}
	
	@PutMapping("/{cargoId}")
	public Cargo atualizar(
			@PathVariable Long cargoId,
			@RequestBody Cargo cargo) {
		
		Cargo cargoAtual = cadastroCargoService.buscarOuFalhar(cargoId);
		
		BeanUtils.copyProperties(cargo, cargoAtual, "id");
		
		return cadastroCargoService.salvar(cargoAtual);
	}
	
	@DeleteMapping("/{cargoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long cargoId) {
		
		cadastroCargoService.excluir(cargoId);
	}
	
}
