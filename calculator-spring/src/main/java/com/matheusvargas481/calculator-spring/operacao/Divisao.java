package com.matheusvargas481.cloudnative.tema1.operacao;

import com.matheusvargas481.cloudnative.tema1.exception.DivisaoPorZeroNaoExisteException;

public class Divisao implements OperacaoMatematica {
    private Double numeroUm, numeroDois;

    public Divisao(Double numeroUm, Double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    @Override
    public Double operacao() {
        if (numeroDois == 0) {
            throw new DivisaoPorZeroNaoExisteException();
        }
        return numeroUm / numeroDois;
    }

    @Override
    public String toString() {
        return "Divisão: " + operacao();
    }
}