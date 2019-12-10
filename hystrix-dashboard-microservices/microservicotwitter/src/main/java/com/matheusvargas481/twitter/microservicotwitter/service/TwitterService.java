package com.matheusvargas481.cloudnative.twitter.microservicotwitter.service;

import com.matheusvargas481.cloudnative.twitter.microservicotwitter.model.Twitter4J;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TwitterService {
    private Twitter4J twitter4J;

    @Autowired
    public TwitterService(Twitter4J twitter4J) { this.twitter4J = twitter4J; }

    @HystrixCommand(fallbackMethod = "fallback")
    public Integer getTwitter4J(String nomeUsuario) throws TwitterException {
        Twitter twitter = twitter4J.getTwitterinstance();
        return twitter.showUser(nomeUsuario).getStatusesCount();
    }

    public Integer fallback(String nomeUsuario) { return 0; }
}
