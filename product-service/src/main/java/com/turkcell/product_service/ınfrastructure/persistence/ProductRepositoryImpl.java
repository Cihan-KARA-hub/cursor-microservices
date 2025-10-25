package com.turkcell.product_service.ınfrastructure.persistence;

import com.turkcell.product_service.applicaiton.ProductRepositoryPort;
import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.domain.valueobjects.ProductId;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryPort {
    private final SpringDataProductRepository productRepository;

    public ProductRepositoryImpl(SpringDataProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
    @Override
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }
    @Override
    public boolean existsById(UUID id) {
        return productRepository.existsById(id);
    }
}
