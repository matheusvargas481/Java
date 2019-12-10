package com.matheusvargas481.cloudnative.tema1;

import com.matheusvargas481.cloudnative.tema1.service.CalculadoraService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculadoraService calculadoraService = (CalculadoraService) applicationContext.getBean("calculadoraService");
        calculadoraService.novoCalculo("+", 10D, 20D);
        calculadoraService.novoCalculo("+", 30D, 20D);
        calculadoraService.novoCalculo("-", 18D, 15D);
        calculadoraService.novoCalculo("*", 16D, 16D);
        calculadoraService.novoCalculo("/", 50D, 5D);
        calculadoraService.novoCalculo("^", 5D, 2D);
        System.out.println("Lista de resultado das Operações\n" + calculadoraService.listarHistorico());
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
