package com.matheussoilegra.coreengineering.tema8.Exceptions;

public class UsuarioComLimiteDiasAtrasoException extends RuntimeException {
    public UsuarioComLimiteDiasAtrasoException() {
        super("Usuário possui mais que 7 dias de atraso.");
    }
}
