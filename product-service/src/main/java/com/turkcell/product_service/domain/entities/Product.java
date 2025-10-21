package com.turkcell.product_service.domain.entities;

import com.turkcell.product_service.domain.valueobjects.Price;
import com.turkcell.product_service.domain.valueobjects.ProductId;
import com.turkcell.product_service.domain.valueobjects.Stock;
import com.turkcell.product_service.exception.DomainException;
import com.turkcell.product_service.exception.message.DomainErrorMessages;

import java.util.Objects;

public class Product {
    private final ProductId id;
    private String name;
    private String description;
    private Price price;
    private Stock stock;

    public Product(ProductId id, String name, String description, Price price, Stock stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
        this.stock = stock;
    }

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public Stock getStock() {
        return stock;
    }

    //create product
    public static Product create(String name, String description, Price price, Stock stock) {
        validateProduct(name, description, price, stock);
        ProductId id = ProductId.generate();
        return new Product(id, name, description, price, stock);
    }

    //reconstruct product
    public static Product reconstruct(ProductId id, String name, String description, Price price, Stock stock) {
        validateProduct(name, description, price, stock);

        return new Product(id, name, description, price, stock);
    }

    //update product
    public void updateProduct(String name, String description) {
        if (name == null || name.trim().isEmpty()) {
            throw new DomainException(DomainErrorMessages.PRODUCT_NAME_CANNOT_EMPTY);
        }
        if (description == null || description.trim().isEmpty()) {
            throw new DomainException(DomainErrorMessages.PRODUCT_DESCRIPTION_CANNOT_BLANK);
        }
        this.name = name.trim();
        this.description = description.trim();
    }

    // update Price
    public void updatePrice(Price newPrice) {
        if (newPrice == null) {
            throw new DomainException(DomainErrorMessages.PRODUCT_PRICE_NOT_NULL);
        }
        this.price = newPrice;
    }

    public void reduceStock(int quantity) {
        if (quantity <= 0) {
            throw new DomainException(DomainErrorMessages.STOCK_MUST_BE_POSITIVE);
        }
        this.stock = this.stock.reduce(quantity);
    }

    public void addStock(int quantity) {
        if (quantity <= 0) {
            throw new DomainException(DomainErrorMessages.STOCK_MUST_BE_POSITIVE);
        }
        this.stock = this.stock.add(quantity);
    }

    public boolean isInStock() {
        return !stock.isOutOfStock();
    }

    public boolean hasEnoughStock(int quantity) {
        return stock.hasEnoughStock(quantity);
    }

    public void increasePriceByPercentage(double percentage) {
        if (percentage < 0) {
            throw new DomainException(DomainErrorMessages.PERCENTAGE_CANNOT_BE_NEGATIVE);
        }
        this.price = this.price.increaseByPercentage(new java.math.BigDecimal(percentage));
    }

    public void decreasePriceByPercentage(double percentage) {
        if (percentage < 0) {
            throw new DomainException(DomainErrorMessages.PERCENTAGE_CANNOT_BE_NEGATIVE);
        }
        this.price = this.price.decreaseByPercentage(new java.math.BigDecimal(percentage));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    private static void validateProduct(String name, String description, Price price, Stock stock) {
        if (name.isBlank())
            throw new DomainException(DomainErrorMessages.PRODUCT_NAME_CANNOT_EMPTY);
        if (description.isBlank())
            throw new DomainException(DomainErrorMessages.PRODUCT_DESCRIPTION_CANNOT_BLANK);
        if (price == null)
            throw new DomainException(DomainErrorMessages.PRODUCT_PRICE_NOT_NULL);
        if (stock == null)
            throw new DomainException(DomainErrorMessages.PRODUCT_STOCK_NOT_NULL);
    }

}
