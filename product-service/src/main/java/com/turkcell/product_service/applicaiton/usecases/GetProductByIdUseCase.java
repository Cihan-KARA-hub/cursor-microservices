package com.turkcell.product_service.applicaiton.usecases;

import com.turkcell.product_service.applicaiton.ProductRepositoryPort;
import com.turkcell.product_service.applicaiton.dto.ProductResponse;
import com.turkcell.product_service.applicaiton.mapper.ProductMapper;
import com.turkcell.product_service.core.exception.ApplicationException;
import com.turkcell.product_service.core.exception.message.ApplicationErrorMessages;
import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.domain.valueobjects.ProductId;

import java.util.UUID;

public class GetProductByIdUseCase {
    private final ProductRepositoryPort productRepository;


    public GetProductByIdUseCase(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;

    }

    public ProductResponse entityToProductResponse(String productId) {
        ProductId id = ProductId.fromString(productId);
        Product product = productRepository.findById(id.getValue()).orElseThrow(() ->
                new ApplicationException(ApplicationErrorMessages.NOT_FOUND_MESSAGE));
        return entityToProductResponse(String.valueOf(product));
    }
}
