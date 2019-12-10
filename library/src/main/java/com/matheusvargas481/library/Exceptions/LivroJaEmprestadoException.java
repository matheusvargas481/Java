package com.matheussoilegra.coreengineering.tema8.Exceptions;

public class LivroJaEmprestadoException extends RuntimeException {
    public LivroJaEmprestadoException() {
        super("Livro já está emprestado.");
    }
}
