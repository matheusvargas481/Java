package com.matheusvargas481.cloudnative.tema2.petstore.exception;

public class PetNaoEncontradoException extends RuntimeException {
    public PetNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
