package com.func.cont.domain.exception;

public class CargoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	
	public CargoNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public CargoNaoEncontradoException(Long cargoId) {
		this(String.format("Não existe cadastro de Cargo com código %d", cargoId));
	}

}
