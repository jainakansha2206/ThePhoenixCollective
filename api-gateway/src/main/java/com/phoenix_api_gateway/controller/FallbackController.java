package com.phoenix_api_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/userFallback")
    public Mono<String> userFallback() {
        return Mono.just("User Service is currently unavailable. Please try later.");
    }

    @GetMapping("/productFallback")
    public Mono<String> productFallback() {
        return Mono.just("Product Service is down. Try again later.");
    }
}
