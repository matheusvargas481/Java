package com.matheusvargas481.cloudnative.twitter.microservicotwitter.model;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ResourceBundle;

public class Twitter4J {
    public Twitter getTwitterinstance() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("twitter4j");
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(resourceBundle.getString("oauth.consumerKey"))
                .setOAuthConsumerSecret(resourceBundle.getString("oauth.consumerSecret"))
                .setOAuthAccessToken(resourceBundle.getString("oauth.accessToken"))
                .setOAuthAccessTokenSecret(resourceBundle.getString("oauth.accessTokenSecret"));
        TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = twitterFactory.getInstance();
        return twitter;
    }
}