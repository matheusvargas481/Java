package com.matheusvargas481.cloudnative.centralmicroservice.exception;

public class UsuarioNaoEncontradoException extends RuntimeException{
    public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado !");
    }
}
