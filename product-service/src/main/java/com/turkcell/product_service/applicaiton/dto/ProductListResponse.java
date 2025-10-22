package com.turkcell.product_service.applicaiton.dto;

import java.util.List;

public class ProductListResponse {
    private final List<ProductResponse> products;

    public ProductListResponse(List<ProductResponse> products) {
        this.products = products;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }
}
