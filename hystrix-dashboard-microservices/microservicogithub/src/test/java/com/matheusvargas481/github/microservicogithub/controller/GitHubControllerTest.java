package com.matheusvargas481.cloudnative.github.microservicogithub.controller;

import com.matheusvargas481.cloudnative.github.microservicogithub.service.GitHubService;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitHubControllerTest {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GitHubService gitHubService;

    @Before
    public void setUp() {
        gitHubService = new GitHubService(restTemplate);
    }

    @Test
    public void testQuantidadeDeRepositoriosPublicosDoGitHub() {
     assertEquals(new Integer(1), gitHubService.getGitHubService("matheusvargas481"));
    }

    public void testUsuarioForInvalido() {
        assertEquals(new Integer(0), gitHubService.getGitHubService("SHAHSAHSHASHAHSAHSHASHA"));
    }
}