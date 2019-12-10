package com.matheusvargas481.cloudnative.rxnetty.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.matheusvargas481.cloudnative.rxnetty.configuracao.AppConfig;
import com.matheusvargas481.cloudnative.rxnetty.exception.DivisaoPorZeroNaoExisteException;

public class CalculadoraServiceTest {
    Injector injector = Guice.createInjector(new AppConfig());
    CalculadoraService calculadoraService = injector.getInstance(CalculadoraService.class);

    @Test
    public void testCalculoDaSoma() {
        assertEquals(7.0, calculadoraService.calcular("som", 5D, 2D), 0);
    }

    @Test
    public void testCalculoDaSubtracao() {
        assertEquals(5D, calculadoraService.calcular("sub", 10D, 5D), 0);
    }

    @Test
    public void testCalculoDaMultiplicacao() { assertEquals(100D, calculadoraService.calcular("multi", 10D, 10D), 0d); }

    @Test
    public void testCalculoDaDivisao() { assertEquals(10D, calculadoraService.calcular("div", 100D, 10D), 0); }

    @Test(expected = DivisaoPorZeroNaoExisteException.class)
    public void testExceptionDoCalculoDaDivisaoPorZero() {
        calculadoraService.calcular("div", 10D, 0D);
    }

    @Test
    public void testCalculoDaPotencia() {
        assertEquals(32D, calculadoraService.calcular("pow", 2D, 5D), 0);
    }

    @Test
    public void testHistorico() {
        calculadoraService.calcular("som", 5D, 5D);
        calculadoraService.calcular("sub", 5D, 5D);
        calculadoraService.calcular("multi", 5D, 5D);
        calculadoraService.calcular("div", 5D, 5D);
        calculadoraService.calcular("pow", 5D, 5D);
        List<String> stringList = calculadoraService.listarHistorico().stream().map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());
        assertThat(stringList, CoreMatchers.hasItems("Soma: 10.0", "Subtração: 0.0", "Multiplicação: 25.0", "Divisão: 1.0", "Potência: 3125.0"));
    }
}
