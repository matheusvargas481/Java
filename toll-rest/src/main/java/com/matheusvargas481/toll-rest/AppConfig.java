package com.matheusvargas481.cloudnative.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.matheusvargas481.cloudnative.rest.dto.VerificoesDTO;
import com.matheusvargas481.cloudnative.rest.veiculos.*;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

@Configuration
@Component
public class AppConfig {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf(){
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer(){
        final JAXRSServerFactoryBean factoryBean = RuntimeDelegate.getInstance().createEndpoint(pedagioController(), JAXRSServerFactoryBean.class);
        factoryBean.setServiceBeans(Arrays.asList(pedagioController()));
        factoryBean.setProviders(Arrays.asList(jsonProvider()));
        return factoryBean.create();
    }

    @Bean(name = "jackson")
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean(name = "pedagio")
    public Pedagio pedagio(){ return new Pedagio(); }

    @Bean(name = "pedagioController")
    public PedagioController pedagioController(){return new PedagioController();}

    @Bean(name = "verificoesDTO")
    public VerificoesDTO verificoesDTO(){return new VerificoesDTO();}

    @Bean(name = "onibus")
    @Scope("prototype")
    public Onibus onibus() { return new Onibus(); }

    @Bean(name = "bicicleta")
    @Scope("prototype")
    public Bicicleta bicicleta() { return new Bicicleta(); }

    @Bean(name = "fusca")
    @Scope("prototype")
    public Fusca fusca() { return new Fusca(); }

    @Bean(name = "moto")
    @Scope("prototype")
    public Moto moto() { return new Moto(); }

    @Bean(name = "caminhao")
    @Scope("prototype")
    public Caminhao caminhao() { return new Caminhao(); }
}
