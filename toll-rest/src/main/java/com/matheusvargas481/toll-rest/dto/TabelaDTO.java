package com.matheusvargas481.cloudnative.rest.dto;

import com.matheusvargas481.cloudnative.rest.veiculos.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class TabelaDTO {

    private List<Veiculo> listaTaxaDosVeiculos = new ArrayList<>();

    public List<Veiculo> getListaTaxaDosVeiculos() { return listaTaxaDosVeiculos; }

    public void setListaTaxaDosVeiculos(List<Veiculo> listaTaxaDosVeiculos) {
        this.listaTaxaDosVeiculos = listaTaxaDosVeiculos;
    }
}
