package com.matheusvargas481.cloudnative.twitter.microservicotwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
public class MicroservicotwitterApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroservicotwitterApplication.class, args);
    }
}
