package com.turkcell.product_service.domain.valueobjects;

import com.turkcell.product_service.core.exception.DomainException;
import com.turkcell.product_service.core.exception.message.DomainErrorMessages;

import java.util.Objects;
import java.util.UUID;

public class ProductId {
    private final UUID id;

    public ProductId(UUID id) {
        this.id = id;
    }

    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
    }

    public static ProductId fromString(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new DomainException(DomainErrorMessages.PRODUCT_ID_CANNOT_NULL);
        }
        try {
            return new ProductId(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            throw new DomainException(DomainErrorMessages.PRODUCT_ID_INVALID_FORMAT + " " + e.getMessage());
        }

    }

    public UUID getValue() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
