package com.matheusvargas481.cloudnative.rxnetty.operacao;

public class Soma implements OperacaoMatematica {
    private Double numeroUm, numeroDois;

    public Soma(Double numeroUm, Double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    @Override
    public Double executar() { return numeroUm + numeroDois; }

    @Override
    public String toString() {
        return "Soma: " + executar();
    }
}