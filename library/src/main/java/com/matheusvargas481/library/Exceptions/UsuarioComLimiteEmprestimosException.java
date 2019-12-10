package com.matheussoilegra.coreengineering.tema8.Exceptions;

public class UsuarioComLimiteEmprestimosException extends RuntimeException {
    public UsuarioComLimiteEmprestimosException() {
        super("Livro já possui 5 empréstimos de livros.");
    }
}
