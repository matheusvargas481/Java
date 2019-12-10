package com.matheusvargas481.cloudnative.tema4;

import com.matheusvargas481.cloudnative.tema4.exception.DivisaoPorZeroNaoExisteException;
import com.matheusvargas481.cloudnative.tema4.exception.ParametroIncorretoException;
import com.matheusvargas481.cloudnative.tema4.service.CalculadoraService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculadoraServlet", urlPatterns = {"/"})
public class CalculadoraServlet extends HttpServlet {
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    private CalculadoraService calculadoraService = (CalculadoraService) applicationContext.getBean("calculadoraService");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Double numeroUm = 0D, numeroDois = 0D;
        String operacao = "";
        try {
            numeroUm = extrairNumeroDoParametro("numeroUm", request);
            numeroDois = extrairNumeroDoParametro("numeroDois", request);
            operacao = extrairParametroDeOperacao(request);
            validarSegundoParametro(numeroDois, operacao);
        } catch (ParametroIncorretoException p) {
            response.getWriter().print("Parametro informado esta incorreto, informe um número !");
        } catch (DivisaoPorZeroNaoExisteException dz) {
            response.getWriter().print("Divisão por zero não existe !");
        }
        Double resultado = calculadoraService.calcular(operacao, numeroUm, numeroDois);
        response.getWriter().println("Calculadora<br>");
        response.getWriter().println(numeroUm + " " + operacao + " " + numeroDois + " = " + resultado);
    }

    private String extrairParametroDeOperacao(HttpServletRequest request) {
        return request.getParameter("operacao");
    }

    private Double extrairNumeroDoParametro(String parametro, HttpServletRequest request) {
        validarParametro(request.getParameter(parametro));
        return Double.parseDouble(request.getParameter(parametro));
    }

    private String validarParametro(String parametro) {
        if (parametro.matches("[A-Za-z]")) {
            throw new ParametroIncorretoException();
        }
        return parametro;
    }

    private Double validarSegundoParametro(Double segundoParametro, String operacao) {
        if (operacao.equals("%2F") || operacao.equals("/") && segundoParametro == 0) {
            throw new DivisaoPorZeroNaoExisteException();
        }
        return segundoParametro;
    }
}
