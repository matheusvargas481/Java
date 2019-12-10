package com.matheusvargas481.cloudnative.rest;

import com.matheusvargas481.cloudnative.rest.dto.PedagioDTO;
import com.matheusvargas481.cloudnative.rest.exception.CondicaoDePagamentoInvalidaException;
import com.matheusvargas481.cloudnative.rest.veiculos.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class PedagioTest {
    @Autowired
    private Pedagio pedagio;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testTaxaDeVeiculos() {
        assertEquals(0.49, new Bicicleta().getPrecoPedagio(), 0d);
        assertEquals(3.95, new Caminhao().getPrecoPedagio(), 0d);
        assertEquals(2.11, new Fusca().getPrecoPedagio(), 0d);
        assertEquals(1D, new Moto().getPrecoPedagio(), 0d);
        assertEquals(1.59, new Onibus().getPrecoPedagio(), 0d);
    }

    @Test
    public void testPagarPedagioBicicleta() {
        PedagioDTO pedagioDTO = new PedagioDTO();
        pedagioDTO.setPagamento(100D);
        assertEquals(99.51, new Bicicleta().pagar(pedagioDTO.getPagamento()), 0D);
    }

    @Test
    public void testPagarPedagioDoCaminhao() {
        PedagioDTO pedagioDTO = new PedagioDTO();
        pedagioDTO.setPagamento(100D);
        Caminhao caminhao = new Caminhao();
        assertEquals(96.05, caminhao.pagar(pedagioDTO.getPagamento()), 0D);
        pedagioDTO.setEixo(2);
        assertEquals(46.05, caminhao.pagar(pedagioDTO.getPagamento() - (pedagioDTO.getEixo() * pedagioDTO.getPrecoPorEixo())), 0D);
    }

    @Test
    public void testPagarPedagioDoFusca() {
        PedagioDTO pedagioDTO = new PedagioDTO();
        pedagioDTO.setPagamento(100D);
        assertEquals(97.89, new Fusca().pagar(pedagioDTO.getPagamento()), 0D);
    }

    @Test
    public void testPagarPedagioDaMoto() {
        PedagioDTO pedagioDTO = new PedagioDTO();
        pedagioDTO.setPagamento(100D);
        assertEquals(99D, new Moto().pagar(pedagioDTO.getPagamento()), 0D);
    }

    @Test
    public void testPagarPedagioDoOnibus() {
        PedagioDTO pedagioDTO = new PedagioDTO();
        pedagioDTO.setPagamento(100D);
        assertEquals(98.41, new Onibus().pagar(pedagioDTO.getPagamento()), 0D);
    }

    @Test(expected = CondicaoDePagamentoInvalidaException.class)
    public void testPagamentoInsuficiente() {
        PedagioDTO pedagioDTO = new PedagioDTO();
        pedagioDTO.setTipoDeVeiculo("onibus");
        Veiculo veiculo = (Veiculo) applicationContext.getBean(pedagioDTO.getTipoDeVeiculo());
        pedagioDTO.setPagamento(veiculo.pagar(-50D));
        pedagio.pagarPedagio(pedagioDTO);
    }

    @Test(expected = CondicaoDePagamentoInvalidaException.class)
    public void testVeiculoInvalido() {
        PedagioDTO pedagioDTO = new PedagioDTO();
        pedagioDTO.setTipoDeVeiculo("lambreta");
        pedagioDTO.setPagamento(50D);
        pedagio.pagarPedagio(pedagioDTO);
    }

    @Test(expected = CondicaoDePagamentoInvalidaException.class)
    public void testVeiculoNulo() {
        PedagioDTO pedagioDTO = new PedagioDTO();
        pedagioDTO.setPagamento(50D);
        pedagio.pagarPedagio(pedagioDTO);
    }
}