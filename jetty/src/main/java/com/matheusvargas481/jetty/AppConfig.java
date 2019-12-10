package com.matheusvargas481.cloudnative.tema4;

import com.matheusvargas481.cloudnative.tema4.operacao.*;
import com.matheusvargas481.cloudnative.tema4.service.CalculadoraService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.matheusvargas481.cloudnative.tema4")
public class AppConfig {

    @Bean(name = "calculadoraService")
    public CalculadoraService calculadoraService() { return new CalculadoraService(); }

    @Bean(name = "+")
    @Scope("prototype")
    public Soma soma(Double numeroUm, Double numeroDois) {
        return new Soma(numeroUm, numeroDois) ;
    }

    @Bean(name = "-")
    @Scope("prototype")
    public Subtracao subtracao(Double numeroUm, Double numeroDois) {
        return new Subtracao(numeroUm, numeroDois);
    }

    @Bean(name = "*")
    @Scope("prototype")
    public Multiplicacao multiplicacao(Double numeroUm, Double numeroDois) { return new Multiplicacao(numeroUm, numeroDois); }

    @Bean(name = "/")
    @Scope("prototype")
    public Divisao divisao(Double numeroUm, Double numeroDois) {
        return new Divisao(numeroUm, numeroDois);
    }

    @Bean(name = "^")
    @Scope("prototype")
    public Potencia potencia(Double numeroUm, Double numeroDois) {
        return new Potencia(numeroUm, numeroDois);
    }
}