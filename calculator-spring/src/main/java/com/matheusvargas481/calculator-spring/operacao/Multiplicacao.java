package com.matheusvargas481.cloudnative.tema1.operacao;

public class Multiplicacao implements OperacaoMatematica {
    private Double numeroUm, numeroDois;

    public Multiplicacao(Double numeroUm, Double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    @Override
    public Double operacao() { return numeroUm * numeroDois; }

    @Override
    public String toString() {
        return "Multiplicação: " + operacao();
    }
}