package com.matheusvargas481.cloudnative.tema6.operacao;

public class Multiplicacao implements OperacaoMatematica {
    private Double numeroUm, numeroDois;

    public Multiplicacao(Double numeroUm, Double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    @Override
    public Double executar() { return numeroUm * numeroDois; }

    @Override
    public String toString() {
        return "Multiplicação: " + executar();
    }
}