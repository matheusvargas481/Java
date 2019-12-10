package com.matheusvargas481.cloudnative.twitter.microservicotwitter.controller;

import com.matheusvargas481.cloudnative.twitter.microservicotwitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

@RestController
@RequestMapping("/twitter")
public class Twitter4JController {
    @Autowired
    private TwitterService twitterService;

    @GetMapping("/{nomeUsuario}")
    public ResponseEntity getQuantidadeDeTweets(@PathVariable("nomeUsuario") String nomeUsuario) throws TwitterException {
        return ResponseEntity.ok(twitterService.getTwitter4J(nomeUsuario));
    }
}
