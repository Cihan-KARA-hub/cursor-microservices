package com.turkcell.product_service.domain.valueobjects;

import com.turkcell.product_service.exception.DomainException;
import com.turkcell.product_service.exception.message.DomainErrorMessages;

import java.math.BigDecimal;


public final class Price {
    private final Currency currency;
    private final BigDecimal price;

    public Price(BigDecimal amount, Currency currency) {
        if (amount == null) {
            throw new DomainException(DomainErrorMessages.PRODUCT_PRICE_NOT_NULL);
        }
        if (currency == null) {
            throw new DomainException(DomainErrorMessages.PRODUCT_CURRENCY_NOT_NULL);

        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new DomainException(DomainErrorMessages.PRICE_MUST_BE_POSITIVE);
        }

        this.price = amount;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isLessThan(Price other) {
        if (!this.currency.equals(other.currency)) {
            throw new  DomainException(DomainErrorMessages.PRODUCT_CURRENCY_DIFFERENT_CANNOT_COMPARED);
        }
        return this.price.compareTo(other.price) < 0;
    }
    public Price increaseByPercentage(BigDecimal percentage) {
        if (percentage == null || percentage.compareTo(BigDecimal.ZERO) < 0) {
            throw new DomainException(DomainErrorMessages.PERCENTAGE_CANNOT_BE_NEGATIVE);
        }
        BigDecimal multiplier = BigDecimal.ONE.add(percentage.divide(new BigDecimal("100")));
        BigDecimal newAmount = this.price.multiply(multiplier);
        return new Price(newAmount, this.currency);
    }
    public Price decreaseByPercentage(BigDecimal percentage) {
        if (percentage == null || percentage.compareTo(BigDecimal.ZERO) < 0) {
            throw  new DomainException(DomainErrorMessages.PERCENTAGE_CANNOT_BE_NEGATIVE);
        }
        BigDecimal multiplier = BigDecimal.ONE.subtract(percentage.divide(new BigDecimal("100")));
        BigDecimal newAmount = this.price.multiply(multiplier);
        return new Price(newAmount, this.currency);
    }
}
