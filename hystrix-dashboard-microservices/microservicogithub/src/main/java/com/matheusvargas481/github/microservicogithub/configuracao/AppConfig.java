package com.matheusvargas481.cloudnative.github.microservicogithub.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean(name = "restTemplate")
    public RestTemplate restTemplate() { return new RestTemplate(); }
}