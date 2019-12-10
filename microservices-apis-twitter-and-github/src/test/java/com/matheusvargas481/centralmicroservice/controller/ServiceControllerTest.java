package com.matheusvargas481.cloudnative.centralmicroservice.controller;

import com.matheusvargas481.cloudnative.centralmicroservice.exception.UsuarioNaoEncontradoException;
import com.matheusvargas481.cloudnative.centralmicroservice.service.CentralService;
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
public class ServiceControllerTest {

    @Autowired
    private RestTemplate restTemplate;
    private CentralService centralService;

    @Before
    public void setUp() {
        centralService = new CentralService(restTemplate);
    }

    @Test
    public void testQuantidadeDeRepositoriosPublicosDoGitHubETweetsDoTwitter() {
        assertEquals(new Integer(1), centralService.numeroDeRepositorioGithub("matheusvargas481"));
        assertEquals(new Integer(85), centralService.numeroDeTweet("AloNegaa"));
    }

    @Test(expected = UsuarioNaoEncontradoException.class)
    public void testUsuarioForInvalido() {
        centralService.numeroDeRepositorioGithub("SBAVDAIVDIAVFIDABFIABFIBAFI");
        centralService.numeroDeTweet("HDVADVAVDAVFDKAVFKVAKFVAKFVAK");
    }
}