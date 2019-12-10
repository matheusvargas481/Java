package com.matheusvargas481.cloudnative.tema2.petstore.service;

public class BanhoSecoEComPerfume implements Servico {
    private static final double VALOR_SERVICO = 180D;

    @Override
    public double fazerServico() { return VALOR_SERVICO; }

    @Override
    public String toString() { return "Banho seco e com perfume: " + "Pet de efetuou o serviço com valor de: R$" + VALOR_SERVICO + "\n";  }
}
