package com.matheusvargas481.cloudnative.centralmicroservico.controller;

import com.matheusvargas481.cloudnative.centralmicroservico.service.CentralService;
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
public class CentralControllerTest {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
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

    @Test
    public void testUsuarioForInvalido() {
        assertEquals(new Integer(0), centralService.numeroDeRepositorioGithub("SBAVDAIVDIAVFIDABFIABFIBAFI"));
        assertEquals(new Integer(0), centralService.numeroDeTweet("HDVADVAVDAVFDKAVFKVAKFVAKFVAK"));
    }
}