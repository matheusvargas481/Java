package com.matheusvargas481.cloudnative.twitter.microservicotwitter.service;

import com.matheusvargas481.cloudnative.twitter.microservicotwitter.exception.UsuarioTwitterNaoEncontradoException;
import com.matheusvargas481.cloudnative.twitter.microservicotwitter.model.Twitter4J;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TwitterService {
    private Twitter4J twitter4J;

    @Autowired
    public TwitterService(Twitter4J twitter4J) {
        this.twitter4J = twitter4J;
    }

    public Integer getTwitter4J(String nomeUsuario) {
        Twitter twitter = twitter4J.getTwitterinstance();
        try {
            return twitter.getUserTimeline(nomeUsuario).get(0).getUser().getStatusesCount();
        } catch (IllegalArgumentException e) {
            throw new UsuarioTwitterNaoEncontradoException();
        } catch (TwitterException e) {
            throw new UsuarioTwitterNaoEncontradoException();
        }
    }
}
