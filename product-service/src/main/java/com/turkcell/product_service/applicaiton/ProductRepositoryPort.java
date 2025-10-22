package com.turkcell.product_service.applicaiton;

import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.domain.valueobjects.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Product save(Product product);

    Optional<Product> findById(ProductId id);

    List<Product> findAll();

    void deleteById(ProductId id);

    boolean existsById(ProductId id);
}
