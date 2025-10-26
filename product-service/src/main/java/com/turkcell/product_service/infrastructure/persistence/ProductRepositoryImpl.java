package com.turkcell.product_service.infrastructure.persistence;

import com.turkcell.product_service.applicaiton.ProductRepositoryPort;
import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.domain.valueobjects.ProductId;
import com.turkcell.product_service.infrastructure.entities.ProductEntity;
import com.turkcell.product_service.infrastructure.mappers.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryPort {
    private final SpringDataProductRepository productRepository;

    public ProductRepositoryImpl(SpringDataProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {

        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity savedEntity = productRepository.save(entity);
        return ProductMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(ProductId id) {
        return productRepository.findById(UUID.fromString(id.toString()))
                .map(ProductMapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name).stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findInStockProducts() {
        return productRepository.findByStockQuantityGreaterThan(0).stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findOutOfStockProducts() {
        return productRepository.findByStockQuantityEquals(0).stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByPriceRange(double minPrice, double maxPrice) {
        return productRepository
                .findByPriceAmountBetween(
                        java.math.BigDecimal.valueOf(minPrice),
                        java.math.BigDecimal.valueOf(maxPrice))
                .stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(ProductId id) {
        productRepository.deleteById(id.getValue());
    }

    @Override
    public boolean existsById(ProductId id) {
        return productRepository.existsById(id.getValue());
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public long countInStockProducts() {
        return productRepository.findByStockQuantityGreaterThan(0).size();
    }
}
