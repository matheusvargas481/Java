package com.matheusvargas481.cloudnative.rxnetty.configuracao;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.matheusvargas481.cloudnative.rxnetty.operacao.Divisao;
import com.matheusvargas481.cloudnative.rxnetty.operacao.Multiplicacao;
import com.matheusvargas481.cloudnative.rxnetty.operacao.OperacaoMatematica;
import com.matheusvargas481.cloudnative.rxnetty.operacao.Potencia;
import com.matheusvargas481.cloudnative.rxnetty.operacao.Soma;
import com.matheusvargas481.cloudnative.rxnetty.operacao.Subtracao;
import com.matheusvargas481.cloudnative.rxnetty.service.CalculadoraService;

public class AppConfig extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    public CalculadoraService providesCalculatorService() {
        Map<String, Class<? extends OperacaoMatematica>> operacaoValida = new HashMap<>();
        operacaoValida.put("div", Divisao.class);
        operacaoValida.put("sub", Subtracao.class);
        operacaoValida.put("som", Soma.class);
        operacaoValida.put("multi", Multiplicacao.class);
        operacaoValida.put("pow", Potencia.class);
        return new CalculadoraService(operacaoValida);
    }
}