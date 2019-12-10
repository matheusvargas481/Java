package com.matheusvargas481.cloudnative.rxnetty.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.matheusvargas481.cloudnative.rxnetty.exception.ParametroIncorretoException;
import com.matheusvargas481.cloudnative.rxnetty.operacao.OperacaoMatematica;

public class CalculadoraService {
    private static List<OperacaoMatematica> historicoDeOperacoes = new ArrayList<>();
    
    public List<OperacaoMatematica> listarHistorico() { return historicoDeOperacoes; }
    
    private Map<String, Class<? extends OperacaoMatematica>> operacaoValida;
    
    public List<String> listaDeOperacoes() { return new ArrayList<>(operacaoValida.keySet()); }

    @Inject
    public CalculadoraService(Map<String, Class<? extends OperacaoMatematica>> operacaoValida) { this.operacaoValida = operacaoValida; }

    public Double calcular(String operacao, Double numeroUm, Double numeroDois) throws ParametroIncorretoException {
        if (operacaoEValida(operacao)) {
            OperacaoMatematica operacaoMatematica = getOperation(operacao, numeroUm, numeroDois);
            Double resultado = operacaoMatematica.executar();
            this.historicoDeOperacoes.add(operacaoMatematica);
            return resultado;
        }
        throw new ParametroIncorretoException();
    }

    private boolean operacaoEValida(String nomeOperacao) {
        return listaDeOperacoes()
                .stream()
                .map(String::toUpperCase)
                .anyMatch(operacao -> operacao.equals(nomeOperacao.toUpperCase()));
    }

    private OperacaoMatematica getOperation(String operacao, Double numeroUm, Double numeroDois) throws ParametroIncorretoException {
        try {
            Class operacaoEncontrada = operacaoValida.get(operacao);
            return (OperacaoMatematica) operacaoEncontrada.getConstructor(Double.class, Double.class)
                    .newInstance(numeroUm, numeroDois);
        } catch (Exception e) {
            throw new ParametroIncorretoException();
        }
    }
}