package com.matheusvargas481.cloudnative.tema3.operacao;

public class Subtracao implements OperacaoMatematica {
    private Double numeroUm, numeroDois;

    public Subtracao(Double numeroUm, Double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    @Override
    public Double executar() { return numeroUm - numeroDois; }

    @Override
    public String toString() {
        return "Subtração: " + executar();
    }
}