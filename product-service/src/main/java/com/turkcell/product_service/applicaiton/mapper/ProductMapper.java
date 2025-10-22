package com.turkcell.product_service.applicaiton.mapper;

import com.turkcell.product_service.applicaiton.dto.CreateProductRequest;
import com.turkcell.product_service.applicaiton.dto.ProductResponse;
import com.turkcell.product_service.applicaiton.dto.UpdateProductRequest;
import com.turkcell.product_service.domain.entities.Product;

public class ProductMapper {

    public static Product createProductRequestToEntity(CreateProductRequest product) {
        return Product.create(product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }

    public static ProductResponse entityToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setStock(product.getStock());
        return productResponse;
    }

    public static void updateEntityFromRequest(Product product, UpdateProductRequest request) {
        Product.reconstruct(product.getId(), request.getName(), request.getDescription(), request.getPrice(), request.getStock());
    }
}
