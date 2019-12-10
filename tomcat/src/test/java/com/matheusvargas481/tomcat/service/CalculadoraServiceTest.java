package com.matheusvargas481.cloudnative.tema1.service;
import com.matheusvargas481.cloudnative.tema3.AppConfig;
import com.matheusvargas481.cloudnative.tema3.exception.DivisaoPorZeroNaoExisteException;
import com.matheusvargas481.cloudnative.tema3.service.CalculadoraService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CalculadoraServiceTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CalculadoraService calculadoraService;

    @Test
    public void testCalculoDaSoma() {
        assertEquals(7.0, calculadoraService.calcular("+", 5D, 2D), 0);
    }

    @Test
    public void testCalculoDaSubtracao() {
        assertEquals(5D, calculadoraService.calcular("-", 10D, 5D), 0);
    }

    @Test
    public void testCalculoDaMultiplicacao() { assertEquals(100D, calculadoraService.calcular("*", 10D, 10D), 0d); }

    @Test
    public void testCalculoDaDivisao() { assertEquals(10D, calculadoraService.calcular("/", 100D, 10D), 0); }

    @Test(expected = DivisaoPorZeroNaoExisteException.class)
    public void testExceptionDoCalculoDaDivisaoPorZero() {
        calculadoraService.calcular("/", 10D, 0D);
    }

    @Test
    public void testCalculoDaPotencia() {
        assertEquals(32D, calculadoraService.calcular("^", 2D, 5D), 0);
    }

    @Test
    public void testHistorico() {
        calculadoraService.calcular("+", 5D, 5D);
        calculadoraService.calcular("-", 5D, 5D);
        calculadoraService.calcular("*", 5D, 5D);
        calculadoraService.calcular("/", 5D, 5D);
        calculadoraService.calcular("^", 5D, 5D);
        List<String> stringList = calculadoraService.listarHistorico().stream().map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());
        assertThat(stringList, CoreMatchers.hasItems("Soma: 10.0", "Subtração: 0.0", "Multiplicação: 25.0", "Divisão: 1.0", "Potência: 3125.0"));
    }
}
