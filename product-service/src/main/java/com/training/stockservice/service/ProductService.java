package com.training.stockservice.service;

import com.training.stockservice.dto.ProductRequest;
import com.training.stockservice.dto.ProductResponse;
import com.training.stockservice.model.Product;
import com.training.stockservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository stockRepository) {
        this.productRepository = stockRepository;
    }

    public ProductResponse createProduct(ProductRequest stockRequest) {

        Product stock = Product.builder()
                .name(stockRequest.getName())
                .description(stockRequest.getDescription())
                .build();

        Product response = productRepository.save(stock);

        return ProductResponse.builder()
                .name(response.getName())
                .description(response.getDescription())
                .build();
    }
}
