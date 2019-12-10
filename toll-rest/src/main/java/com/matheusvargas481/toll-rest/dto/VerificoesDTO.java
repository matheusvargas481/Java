package com.matheusvargas481.cloudnative.rest.dto;

import com.matheusvargas481.cloudnative.rest.veiculos.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class VerificoesDTO {
    @Autowired
    ApplicationContext applicationContext;

    public boolean condicoesDePagamentoValido(PedagioDTO pedagioDTO) {
        return verificarPagamentoValido(pedagioDTO) && verificarPagamentoSuficiente(pedagioDTO) && verificarVeiculoValido(pedagioDTO);
    }

    private boolean verificarVeiculoValido(PedagioDTO pedagioDTO) {
        List<String> listaVeiculos = Arrays.asList(applicationContext.getBeanNamesForType(Veiculo.class));
        Optional<String> veiculoExistente = listaVeiculos.stream()
                .filter(veiculo -> veiculo.equals(pedagioDTO.getTipoDeVeiculo()))
                .findFirst();
        return veiculoExistente.isPresent();
    }

    private boolean verificarPagamentoSuficiente(PedagioDTO pedagioDTO) {
        return pedagioDTO.getPagamento() > 0;
    }

    private boolean verificarPagamentoValido(PedagioDTO pedagioDTO) {
        return pedagioDTO.getPagamento() != null;
    }
}
