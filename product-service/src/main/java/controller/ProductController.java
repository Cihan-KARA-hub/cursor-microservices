package com.turkcell.product_service.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @GetMapping("/get")
    public String getProduct() {
        return "Product";
    }

    @PostMapping("/create")
    public String createProduct() {
        return "Product created";
    }
    @PutMapping("/update")
    public String updateProduct() {
        return "Product updated";
    }
    @DeleteMapping("/delete")
    public String deleteProduct() {
        return "Product deleted";
    }
}
