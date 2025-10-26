package com.turkcell.product_service.infrastructure.mappers;


import com.turkcell.product_service.domain.entities.Product;
import com.turkcell.product_service.domain.valueobjects.Currency;
import com.turkcell.product_service.domain.valueobjects.Price;
import com.turkcell.product_service.domain.valueobjects.ProductId;
import com.turkcell.product_service.domain.valueobjects.Stock;
import com.turkcell.product_service.infrastructure.entities.ProductEntity;

public class ProductMapper {

    public static ProductEntity toEntity(Product product) {
        return new ProductEntity(
                product.getId().toString(),
                product.getName(),
                product.getDescription(),
                product.getPrice().getPrice(),
                product.getPrice().getCurrency().getCode(),
                product.getStock().getQuantity());
    }

    public static Product toDomain(ProductEntity entity) {
        ProductId productId = ProductId.fromString(entity.getId());
        Currency currency = Currency.fromCode(entity.getPriceCurrency());
        Price price = new Price(entity.getPriceAmount(), currency);
        Stock stock = new Stock(entity.getStockQuantity());

        return Product.reconstruct(
                productId,
                entity.getName(),
                entity.getDescription(),
                price,
                stock);
    }

    private ProductMapper() {
    }
}
