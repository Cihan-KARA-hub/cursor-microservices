package com.turkcell.product_service.applicaiton.usecases;

import com.turkcell.product_service.applicaiton.ProductRepositoryPort;
import com.turkcell.product_service.applicaiton.dto.CreateProductRequest;
import com.turkcell.product_service.applicaiton.dto.ProductResponse;
import com.turkcell.product_service.applicaiton.mapper.ProductMapper;
import com.turkcell.product_service.domain.entities.Product;
import org.springframework.stereotype.Service;

import static com.turkcell.product_service.applicaiton.mapper.ProductMapper.createProductRequestToEntity;
import static com.turkcell.product_service.applicaiton.mapper.ProductMapper.entityToProductResponse;
@Service
public class CreateProductUseCase {
    private final ProductRepositoryPort productRepository;

    public CreateProductUseCase(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;

    }
    public ProductResponse execute(CreateProductRequest createProductRequest) {
        Product product= createProductRequestToEntity(createProductRequest);
        productRepository.save(product);
        return entityToProductResponse(product);
    }

}
