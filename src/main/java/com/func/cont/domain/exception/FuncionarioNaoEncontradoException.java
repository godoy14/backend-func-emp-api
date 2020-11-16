package com.func.cont.domain.exception;

public class FuncionarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public FuncionarioNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public FuncionarioNaoEncontradoException(Long funcionarioId) {
		this(String.format("Não existe cadastro de Funcionario com código %d", funcionarioId));
	}

	

}
