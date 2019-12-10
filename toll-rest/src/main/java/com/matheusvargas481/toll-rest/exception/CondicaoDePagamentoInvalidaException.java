package com.matheusvargas481.cloudnative.rest.exception;

public class CondicaoDePagamentoInvalidaException extends RuntimeException {
    public CondicaoDePagamentoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
