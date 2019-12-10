package com.matheusvargas481.cloudnative.tema1.service;

import com.matheusvargas481.cloudnative.tema1.operacao.OperacaoMatematica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraService {

    @Autowired
    ApplicationContext applicationContext;

    private static List<OperacaoMatematica> historicoDeOperacoes = new ArrayList<>();

    public void guardarOperacao(OperacaoMatematica operacaoMatematica) {
        historicoDeOperacoes.add(operacaoMatematica);
    }

    public List<OperacaoMatematica> listarHistorico() {
        return historicoDeOperacoes;
    }

    public Double novoCalculo(String operacao, Double numeroUm, Double numeroDois) {
        OperacaoMatematica operacaoMatematica = (OperacaoMatematica) applicationContext.getBean(operacao, numeroUm, numeroDois);
        this.guardarOperacao(operacaoMatematica);
        return operacaoMatematica.operacao();
    }
}
