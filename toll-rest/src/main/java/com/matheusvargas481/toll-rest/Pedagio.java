package com.matheusvargas481.cloudnative.rest;

import com.matheusvargas481.cloudnative.rest.dto.PedagioDTO;
import com.matheusvargas481.cloudnative.rest.dto.TabelaDTO;
import com.matheusvargas481.cloudnative.rest.dto.VerificoesDTO;
import com.matheusvargas481.cloudnative.rest.exception.CondicaoDePagamentoInvalidaException;
import com.matheusvargas481.cloudnative.rest.veiculos.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Pedagio {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private VerificoesDTO verificoesDTO;

    public TabelaDTO tabelaDeTaxas() {
        TabelaDTO tabelaDTO = new TabelaDTO();
        List<Veiculo> listaDeVeiculos = Arrays.asList((Veiculo) applicationContext.getBean("bicicleta"), (Veiculo) applicationContext.getBean("caminhao"), (Veiculo) applicationContext.getBean("fusca"), (Veiculo) applicationContext.getBean("moto"), (Veiculo) applicationContext.getBean("onibus"));
        tabelaDTO.setListaTaxaDosVeiculos(listaDeVeiculos);
        return tabelaDTO;
    }

    public Double pagarPedagio(PedagioDTO pedagioDTO) {
        if (verificoesDTO.condicoesDePagamentoValido(pedagioDTO)) {
            Veiculo veiculo = (Veiculo) applicationContext.getBean(pedagioDTO.getTipoDeVeiculo());
            if (pedagioDTO.getTipoDeVeiculo().equals("caminhao") && pedagioDTO.getEixo() > 1) {
                return veiculo.pagar(pedagioDTO.getPagamento() - (pedagioDTO.getEixo() * pedagioDTO.getPrecoPorEixo()));
            }
            return veiculo.pagar(pedagioDTO.getPagamento());
        }
        throw new CondicaoDePagamentoInvalidaException("Condição de pagamento inválida");
    }
}