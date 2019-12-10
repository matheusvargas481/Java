package com.matheusvargas481.cloudnative.tema4.operacao;

public class Potencia implements OperacaoMatematica {
    private Double numeroUm, numeroDois;

    public Potencia(Double numeroUm, Double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    @Override
    public Double executar() { return Math.pow(numeroUm, numeroDois); }

    @Override
    public String toString() {
        return "Potência: " + executar();
    }
}