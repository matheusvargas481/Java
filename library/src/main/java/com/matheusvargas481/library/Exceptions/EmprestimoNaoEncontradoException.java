package com.matheussoilegra.coreengineering.tema8.Exceptions;

public class EmprestimoNaoEncontradoException extends RuntimeException {
    public EmprestimoNaoEncontradoException() {
        super("Empréstimo com esse id não foi encontrado");
    }
}
