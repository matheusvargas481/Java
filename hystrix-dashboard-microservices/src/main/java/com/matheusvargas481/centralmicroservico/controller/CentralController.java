package com.matheusvargas481.cloudnative.centralmicroservico.controller;

import com.matheusvargas481.cloudnative.centralmicroservico.service.CentralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class CentralController {

    @Autowired
    private CentralService centralService;

    @GetMapping("/{usuarioGitHub}/{usuarioTwitter}")
    @ResponseBody
    public Map<String, Integer> getNumerodeRepositoriosGitHubETweets(@PathVariable("usuarioGitHub") String usuarioGitHub, @PathVariable("usuarioTwitter") String usuarioTwitter) {
        Map<String, Integer> result = new HashMap<>();
        result.put("quantidadeDeRepositorios", centralService.numeroDeRepositorioGithub(usuarioGitHub));
        result.put("quantidadeDeTweets", centralService.numeroDeTweet(usuarioTwitter));
        return result;
    }
}
