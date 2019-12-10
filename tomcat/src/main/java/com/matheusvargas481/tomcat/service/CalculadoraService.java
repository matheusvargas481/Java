package com.matheusvargas481.cloudnative.tema3.service;

import com.matheusvargas481.cloudnative.tema3.operacao.OperacaoMatematica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraService {

    @Autowired
    private ApplicationContext applicationContext;

    private static List<OperacaoMatematica> historicoDeOperacoes = new ArrayList<>();

    public List<OperacaoMatematica> listarHistorico() { return historicoDeOperacoes; }

    public Double calcular(String operacao, Double numeroUm, Double numeroDois) {
        OperacaoMatematica operacaoMatematica = (OperacaoMatematica) applicationContext.getBean(operacao, numeroUm, numeroDois);
        this.historicoDeOperacoes.add(operacaoMatematica);
        return operacaoMatematica.executar();
    }
}
