package com.matheussoilegra.coreengineering.tema10.com.matheussoilegra.coreengineering.tema10.exceptions;

public class ContatoNaoEncontradoException extends RuntimeException {
    public ContatoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
