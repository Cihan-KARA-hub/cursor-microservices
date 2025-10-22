package com.turkcell.product_service.applicaiton.usecases;

import com.turkcell.product_service.applicaiton.ProductRepositoryPort;
import com.turkcell.product_service.core.exception.ApplicationException;
import com.turkcell.product_service.core.exception.message.ApplicationErrorMessages;
import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.domain.valueobjects.ProductId;

public class DeleteProductUseCase {
    private final ProductRepositoryPort productRepository;

    public DeleteProductUseCase(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(String id) {
        ProductId productId = ProductId.fromString(id);
        boolean exist = productRepository.existsById(productId);
        if (!exist) {
            throw new ApplicationException(ApplicationErrorMessages.NOT_FOUND_MESSAGE);
        } else {
            productRepository.deleteById(productId);
        }
    }
}
