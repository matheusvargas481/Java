package com.matheusvargas481.cloudnative.github.microservicogithub.controller;

import com.matheusvargas481.cloudnative.github.microservicogithub.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class GitHubController {
    @Autowired
    private GitHubService gitHubService;

    @GetMapping("/{nomeUsuario}")
    public ResponseEntity getQuantidadeDeRepositorios(@PathVariable("nomeUsuario") String nomeUsuario) {
        return ResponseEntity.ok(gitHubService.getGitHubService(nomeUsuario));
    }
}
