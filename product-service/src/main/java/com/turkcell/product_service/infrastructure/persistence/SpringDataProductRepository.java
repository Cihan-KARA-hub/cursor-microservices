package com.turkcell.product_service.infrastructure.persistence;

import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Repository
public interface SpringDataProductRepository extends JpaRepository<ProductEntity, UUID> {
    List<ProductEntity> findByNameContaining(String name);

    List<ProductEntity> findByStockQuantityGreaterThan(Integer quantity);

    List<ProductEntity> findByStockQuantityEquals(Integer quantity);

    List<ProductEntity> findByPriceAmountBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
