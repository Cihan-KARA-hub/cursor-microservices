package com.turkcell.product_service.applicaiton.usecases;


import com.turkcell.product_service.applicaiton.ProductRepositoryPort;
import com.turkcell.product_service.applicaiton.dto.ProductListResponse;
import com.turkcell.product_service.applicaiton.dto.ProductResponse;
import com.turkcell.product_service.applicaiton.mapper.ProductMapper;
import com.turkcell.product_service.domain.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class GetAllProductsUseCase {
    private final ProductRepositoryPort productRepository;


    public GetAllProductsUseCase(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;

    }

    public ProductListResponse handle() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = products.stream()
                .map(ProductMapper::entityToProductResponse)
                .collect(Collectors.toList());
        return new ProductListResponse(productResponses);

    }

}

