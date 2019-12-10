package com.matheusvargas481.cloudnative.github.microservicogithub.controller;

import com.matheusvargas481.cloudnative.github.microservicogithub.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/github")
public class GitHubController {
    @Autowired
    private GitHubService gitHubService;

    @GetMapping("/{nomeUsuario}")
    @ResponseBody
    public Integer getQuantidadeDeRepositorios(@PathVariable("nomeUsuario") String nomeUsuario) {
        return gitHubService.getGitHubService(nomeUsuario);
    }
}
