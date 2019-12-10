package com.matheusvargas481.cloudnative.rxnetty.operacao;

import com.matheusvargas481.cloudnative.rxnetty.exception.DivisaoPorZeroNaoExisteException;

public class Divisao implements OperacaoMatematica {
    private Double numeroUm, numeroDois;

    public Divisao(Double numeroUm, Double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    @Override
    public Double executar() {
        if (numeroDois == 0) {
            throw new DivisaoPorZeroNaoExisteException();
        }
        return numeroUm / numeroDois;
    }

    @Override
    public String toString() {
        return "Divisão: " + executar();
    }
}