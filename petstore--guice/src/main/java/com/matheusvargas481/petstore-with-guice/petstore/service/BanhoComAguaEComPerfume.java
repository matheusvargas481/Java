package com.matheusvargas481.cloudnative.tema2.petstore.service;

public class BanhoComAguaEComPerfume implements Servico {
    private static final double VALOR_SERVICO = 130D;

    @Override
    public double fazerServico() { return VALOR_SERVICO; }

    @Override
    public String toString() { return "Banho com água e com perfume: " + "Pet efetuou o serviço com valor de: R$" + VALOR_SERVICO + "\n"; }
}
