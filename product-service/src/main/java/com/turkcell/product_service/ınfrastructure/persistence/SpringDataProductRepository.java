package com.turkcell.product_service.ınfrastructure.persistence;

import com.turkcell.product_service.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataProductRepository extends JpaRepository<Product, UUID> {
}
