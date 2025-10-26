package com.turkcell.product_service.applicaiton;

import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.domain.valueobjects.ProductId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    Product save(Product product);

    Optional<Product> findById(ProductId id);
    List<Product> findAll();

    List<Product> findByNameContaining(String name);

    List<Product> findInStockProducts();


    List<Product> findOutOfStockProducts();


    List<Product> findByPriceRange(double minPrice, double maxPrice);


    void deleteById(ProductId id);


    boolean existsById(ProductId id);


    long count();



    long countInStockProducts();
}
