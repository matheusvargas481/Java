package com.matheusvargas481.cloudnative.centralmicroservico.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ResourceBundle;

@Service
public class CentralService {
    private RestTemplate restTemplate;

    @Autowired
    public CentralService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Integer numeroDeRepositorioGithub(String nomeUsuario) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        return restTemplate.getForObject(resourceBundle.getString("URL_GITHUB_CENTRAL") + nomeUsuario, Integer.class);
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Integer numeroDeTweet(String nomeUsuario) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        return restTemplate.getForObject(resourceBundle.getString("URL_TWITTER") + nomeUsuario, Integer.class);
    }

    public Integer fallback(String nomeUsuario) { return 0; }
}
