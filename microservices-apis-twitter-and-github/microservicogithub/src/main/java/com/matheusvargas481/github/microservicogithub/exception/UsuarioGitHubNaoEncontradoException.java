package com.matheusvargas481.cloudnative.github.microservicogithub.exception;

public class UsuarioGitHubNaoEncontradoException extends RuntimeException {
    public UsuarioGitHubNaoEncontradoException() {
        super("Usuário não encontrado !");
    }
}
