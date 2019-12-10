package com.matheussoilegra.coreengineering.tema8.Exceptions;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException() {
        super("Livro não encontrado.");
    }
}
