package com.matheusvargas481.cloudnative.github.microservicogithub.service;

import com.matheusvargas481.cloudnative.github.microservicogithub.exception.UsuarioGitHubNaoEncontradoException;
import com.matheusvargas481.cloudnative.github.microservicogithub.model.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {
    private RestTemplate restTemplate;

    @Autowired
    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String URL_GITHUB = "https://api.github.com/users/";

    public Integer getGitHubService(String nomeUsuario) {
        try {
            GitHub gitHub = restTemplate.getForObject(URL_GITHUB + nomeUsuario, GitHub.class);
            return gitHub.getQuantidadeRepositorio();
        } catch (ResourceAccessException | HttpClientErrorException e) {
            throw new UsuarioGitHubNaoEncontradoException();
        }
    }
}
