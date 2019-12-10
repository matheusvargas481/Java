package com.matheusvargas481.cloudnative.twitter.microservicotwitter.controller;

import com.matheusvargas481.cloudnative.twitter.microservicotwitter.exception.UsuarioTwitterNaoEncontradoException;
import com.matheusvargas481.cloudnative.twitter.microservicotwitter.model.Twitter4J;
import com.matheusvargas481.cloudnative.twitter.microservicotwitter.service.TwitterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Twitter4JControllerTest {

    @Autowired
    private Twitter4J twitter4J;
    private TwitterService twitterService;

    @Before
    public void setUp() {
        twitterService = new TwitterService(twitter4J);
    }

    @Test
    public void testQuantidadeDeRepositoriosPublicosDoTwitter() {
        assertEquals(new Integer(85), twitterService.getTwitter4J("AloNegaa"));
    }

    @Test(expected = UsuarioTwitterNaoEncontradoException.class)
    public void testUsuarioForInvalido() {
        twitterService.getTwitter4J("SBHAHSHASHAHSHASHAHSHASHASA");
    }
}