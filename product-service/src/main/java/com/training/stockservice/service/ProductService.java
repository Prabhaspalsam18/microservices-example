package com.training.stockservice.service;

import com.training.stockservice.dto.ProductRequest;
import com.training.stockservice.dto.ProductResponse;
import com.training.stockservice.model.Product;
import com.training.stockservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<ProductResponse> getAllProducts() {

        List<ProductResponse> productResponses = new ArrayList<>();

        for (Product product: productRepository.findAll()) {
            productResponses.add(new ProductResponse(product.getName(), product.getDescription(), 0.0));
        }

        return productResponses;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .build();

        Product response = productRepository.save(product);

        return ProductResponse.builder()
                .name(response.getName())
                .description(response.getDescription())
                .build();
    }
}
