package com.brq.exceptions;

// exceção personalisada, devemos pegar a classe Runtimeexception com herança
@SuppressWarnings("serial")
public class ObjetoNaoEncontradoException extends RuntimeException {

	public ObjetoNaoEncontradoException (String mensagem) {
		super(mensagem);
	}

}
