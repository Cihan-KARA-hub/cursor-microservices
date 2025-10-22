package com.turkcell.product_service.applicaiton.usecases;


import com.turkcell.product_service.applicaiton.ProductRepositoryPort;
import com.turkcell.product_service.applicaiton.dto.ProductResponse;
import com.turkcell.product_service.applicaiton.mapper.ProductMapper;
import com.turkcell.product_service.domain.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllProductsUseCase {
    private final ProductRepositoryPort productRepository;


    public GetAllProductsUseCase(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;

    }

    public List<ProductResponse> handle() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::entityToProductResponse)
                .collect(Collectors.toList());
    }

}

