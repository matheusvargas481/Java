package com.matheusvargas481.cloudnative.tema3;

import com.matheusvargas481.cloudnative.tema3.service.CalculadoraService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HistoricoServlet", urlPatterns = {"/historico"})
public class HistoricoServlet extends HttpServlet {
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    private CalculadoraService calculadoraService = (CalculadoraService) applicationContext.getBean("calculadoraService");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("Histórico de Operações:" + "<br>" + calculadoraService.listarHistorico()
                .toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "<br>")
                .trim());
    }
}
