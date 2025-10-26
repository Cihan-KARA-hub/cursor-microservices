package com.turkcell.product_service.applicaiton;

import com.turkcell.product_service.applicaiton.dto.CreateProductRequest;
import com.turkcell.product_service.applicaiton.dto.ProductListResponse;
import com.turkcell.product_service.applicaiton.dto.ProductResponse;
import com.turkcell.product_service.applicaiton.dto.UpdateProductRequest;

import java.util.List;
import java.util.UUID;

public interface ProductServicePort {
    ProductResponse createProduct(CreateProductRequest request);

    ProductResponse getProductById(String id);

   ProductListResponse getAllProducts();

    ProductResponse updateProduct(String id, UpdateProductRequest request);

    void deleteProduct(String id);
}
