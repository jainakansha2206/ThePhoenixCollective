package com.thephoenixcollective.product_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @GetMapping("/health")
    public String health() {
        return "{\"status\":\"Product Service UP!\"}";
    }

}
