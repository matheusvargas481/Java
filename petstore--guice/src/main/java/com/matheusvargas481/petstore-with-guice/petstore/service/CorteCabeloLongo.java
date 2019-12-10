package com.matheusvargas481.cloudnative.tema2.petstore.service;

public class CorteCabeloLongo implements Servico {
    private static final double VALOR_SERVICO = 80D;

    @Override
    public double fazerServico() {
        return VALOR_SERVICO;
    }

    @Override
    public String toString() { return "Serviço de Corte Longo: " + "Pet efetuou o serviço de no valor de: R$" + VALOR_SERVICO + "\n"; }
}
