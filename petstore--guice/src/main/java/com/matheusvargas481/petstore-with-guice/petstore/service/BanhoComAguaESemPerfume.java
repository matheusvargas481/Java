package com.matheusvargas481.cloudnative.tema2.petstore.service;

public class BanhoComAguaESemPerfume implements Servico {
    private static final double VALOR_SERVICO = 100D;

    @Override
    public double fazerServico() { return VALOR_SERVICO; }

    @Override
    public String toString() { return "Banho com água e sem perfume: " + "Pet efetuou o serviço com valor de: R$" + VALOR_SERVICO + "\n"; }
}
