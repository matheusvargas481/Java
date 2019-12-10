package com.matheussoilegra.coreengineering.tema6;

public class ContatoNaoEncontradoException extends RuntimeException {
    public ContatoNaoEncontradoException(){
        super("Contato não encontrado.");
    }
}
