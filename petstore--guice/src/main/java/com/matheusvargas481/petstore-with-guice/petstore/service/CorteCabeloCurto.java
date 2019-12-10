package com.matheusvargas481.cloudnative.tema2.petstore.service;

public class CorteCabeloCurto implements Servico {
    private static final double VALOR_SERVICO = 50D;

    @Override
    public double fazerServico() { return VALOR_SERVICO; }

    @Override
    public String toString() { return "Serviço de Corte Curto: " + "Pet efetuou o serviço no valor de: R$" + VALOR_SERVICO + "\n"; }
}
