package com.matheusvargas481.cloudnative.tema1.exception;

public class DivisaoPorZeroNaoExisteException extends RuntimeException {
    public DivisaoPorZeroNaoExisteException() {
        super("Divisão por 0 não existe !");
    }
}
