package com.matheusvargas481.cloudnative.rest;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        final ServletHolder servletHolder = new ServletHolder(new CXFServlet());
        final ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setContextPath("/");
        contextHandler.addServlet(servletHolder, "/rest/*");
        contextHandler.addEventListener(new ContextLoaderListener());

        contextHandler.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        contextHandler.setInitParameter("contextConfigLocation", AppConfig.class.getName());
        server.setHandler(contextHandler);

        server.start();
        server.join();
    }
}
