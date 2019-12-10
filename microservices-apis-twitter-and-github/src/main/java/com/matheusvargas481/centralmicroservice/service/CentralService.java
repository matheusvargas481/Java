package com.matheusvargas481.cloudnative.centralmicroservice.service;

import com.matheusvargas481.cloudnative.centralmicroservice.exception.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class CentralService {
    private static final String URL_GITHUB = "http://localhost:8082/github/";
    private static final String URL_TWITTER = "http://localhost:8081/twitter/";

    private RestTemplate restTemplate;

    @Autowired
    public CentralService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Integer numeroDeRepositorioGithub(String nomeUsuario) {
        try {
            return restTemplate.getForObject(URL_GITHUB + nomeUsuario, Integer.class);
        } catch (ResourceAccessException | HttpClientErrorException e) {
            throw new UsuarioNaoEncontradoException();
        }
    }

    public Integer numeroDeTweet(String nomeUsuario) {
        try {
            return restTemplate.getForObject(URL_TWITTER + nomeUsuario, Integer.class);
        } catch (ResourceAccessException | HttpClientErrorException e) {
            throw new UsuarioNaoEncontradoException();
        }
    }
}
