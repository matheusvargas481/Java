package com.matheusvargas481.cloudnative.twitter.microservicotwitter.configuracao;

import com.matheusvargas481.cloudnative.twitter.microservicotwitter.model.Twitter4J;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "twitter4J")
    public Twitter4J twitter4J() { return new Twitter4J(); }

}