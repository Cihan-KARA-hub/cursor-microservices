package com.turkcell.product_service.web.controllers;

import com.turkcell.product_service.applicaiton.ProductService;
import com.turkcell.product_service.applicaiton.dto.CreateProductRequest;
import com.turkcell.product_service.applicaiton.dto.ProductListResponse;
import com.turkcell.product_service.applicaiton.dto.ProductResponse;
import com.turkcell.product_service.applicaiton.dto.UpdateProductRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Product REST Controller
 * RESTful API endpoint'lerini yönetir
 * Dependency Inversion Principle: Interface'e bağımlı (ProductServicePort)
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductListResponse getAllProducts() {
        ProductListResponse response = productService.getAllProducts();
        return response;
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable String id) {
        return productService.getProductById(id);

    }


    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable String id,
            @Valid @RequestBody UpdateProductRequest request) {
        ProductResponse response = productService.updateProduct(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
