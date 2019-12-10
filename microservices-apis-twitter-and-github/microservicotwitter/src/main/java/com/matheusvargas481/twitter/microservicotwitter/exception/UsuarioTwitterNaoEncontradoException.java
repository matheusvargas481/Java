package com.matheusvargas481.cloudnative.twitter.microservicotwitter.exception;

public class UsuarioTwitterNaoEncontradoException extends RuntimeException {
    public UsuarioTwitterNaoEncontradoException() {
        super("Usuário não encontrado !");
    }
}
