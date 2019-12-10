package com.matheusvargas481.cloudnative.tema2.petstore.service;

public class BanhoSecoESemPerfume implements Servico {
    private static final double VALOR_SERVICO = 150D;

    @Override
    public double fazerServico() { return VALOR_SERVICO; }

    @Override
    public String toString() { return "Banho seco e sem perfume: " + "Pet efetuou o serviço com valor de: R$" + VALOR_SERVICO + "\n"; }
}
