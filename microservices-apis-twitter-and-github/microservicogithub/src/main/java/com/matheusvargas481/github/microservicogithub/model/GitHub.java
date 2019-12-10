package com.matheusvargas481.cloudnative.github.microservicogithub.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHub {
    @JsonProperty("public_repos")
    private int quantidadeRepositorio;

    public int getQuantidadeRepositorio() {
        return quantidadeRepositorio;
    }

}
