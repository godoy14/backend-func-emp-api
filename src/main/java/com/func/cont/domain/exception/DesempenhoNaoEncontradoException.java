package com.func.cont.domain.exception;

public class DesempenhoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	
	public DesempenhoNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public DesempenhoNaoEncontradoException(Long desempenhoId) {
		this(String.format("Não existe cadastro de Desempenho com código %d", desempenhoId));
	}

}
