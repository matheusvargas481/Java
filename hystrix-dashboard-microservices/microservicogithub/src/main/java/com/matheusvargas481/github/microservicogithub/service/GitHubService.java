package com.matheusvargas481.cloudnative.github.microservicogithub.service;

import com.matheusvargas481.cloudnative.github.microservicogithub.model.GitHub;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ResourceBundle;

@Service
public class GitHubService {
    private RestTemplate restTemplate;

    @Autowired
    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Integer getGitHubService(String nomeUsuario) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        GitHub gitHub = restTemplate.getForObject(resourceBundle.getString("URL_GITHUB") + nomeUsuario, GitHub.class);
        return gitHub.getQuantidadeRepositorio();
    }
    public Integer fallback(String nomeUsuario) {
        return 0;
    }
}
