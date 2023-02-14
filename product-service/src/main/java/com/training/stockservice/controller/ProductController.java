package com.training.stockservice.controller;

import com.training.stockservice.dto.ProductRequest;
import com.training.stockservice.dto.ProductResponse;
import com.training.stockservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    private final ProductService productService;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public ProductController(ProductService productService, WebClient.Builder webClientBuilder) {
        this.productService = productService;
        this.webClientBuilder = webClientBuilder;
    }


    @GetMapping
    public String getAllProducts() {
        String response = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        log.info("order response: " + response);

        return response;
    }

    @PostMapping("/v2")
    public ProductResponse createProduct(@RequestBody ProductRequest stockRequest) {
        return productService.createProduct(stockRequest);
    }
}
