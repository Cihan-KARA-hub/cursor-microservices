package com.turkcell.product_service.domain.valueobjects;

import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.exception.DomainException;
import com.turkcell.product_service.exception.message.DomainErrorMessages;

import java.util.Objects;

public final class Stock {
    private final int quantity;

    public Stock(int quantity) {
        if (quantity <= 0) {
            throw new DomainException(DomainErrorMessages.STOCK_MUST_BE_POSITIVE);
        }
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public boolean isOutOfStock() {
        return this.quantity == 0;
    }

    public boolean hasEnoughStock(int requestedQuantity) {
        if (requestedQuantity < 0) {
            throw new DomainException(DomainErrorMessages.STOCK_CANNOT_BE_NEGATIVE);
        }
        return quantity >= requestedQuantity;
    }

    public Stock reduce(int amount) {
        if (amount < 0) {
            throw new DomainException(DomainErrorMessages.STOCK_CANNOT_BE_NEGATIVE);
        }
        if (amount > quantity) {
            throw new DomainException(DomainErrorMessages.INSUFFICIENT_STOCK + quantity + ", İstenen: " + amount);
        }
        return new Stock(quantity - amount);
    }

    public Stock add(int amount) {
        if (amount < 0) {
            throw new DomainException(DomainErrorMessages.STOCK_CANNOT_BE_NEGATIVE);
        }
        return new Stock(quantity + amount);
    }

    public Stock update(int newQuantity) {
        if (newQuantity < 0) {
            throw new DomainException(DomainErrorMessages.STOCK_CANNOT_BE_NEGATIVE);
        }
        return new Stock(newQuantity);
    }

    public boolean isGreaterThan(Stock other) {
        return this.quantity > other.quantity;
    }

    public boolean isLessThan(Stock other) {
        return this.quantity < other.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return quantity == stock.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quantity);
    }

    @Override
    public String toString() {
        return String.valueOf(this.quantity);
    }
}
