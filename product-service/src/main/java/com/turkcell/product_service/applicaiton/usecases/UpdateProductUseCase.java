package com.turkcell.product_service.applicaiton.usecases;


import com.turkcell.product_service.applicaiton.ProductRepositoryPort;
import com.turkcell.product_service.applicaiton.dto.ProductResponse;
import com.turkcell.product_service.applicaiton.dto.UpdateProductRequest;
import com.turkcell.product_service.applicaiton.mapper.ProductMapper;
import com.turkcell.product_service.core.exception.ApplicationException;
import com.turkcell.product_service.core.exception.message.ApplicationErrorMessages;
import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.domain.valueobjects.ProductId;

import static com.turkcell.product_service.applicaiton.mapper.ProductMapper.entityToProductResponse;
import static com.turkcell.product_service.applicaiton.mapper.ProductMapper.updateEntityFromRequest;

public class UpdateProductUseCase {
    private final ProductRepositoryPort productRepository;

    public UpdateProductUseCase(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;

    }

    public ProductResponse handle(String id, UpdateProductRequest request) {
        ProductId productId = ProductId.fromString(id);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ApplicationException(ApplicationErrorMessages.NOT_FOUND_MESSAGE));

        updateEntityFromRequest(product, request);
        productRepository.save(product);
        return entityToProductResponse(product);
    }
}

