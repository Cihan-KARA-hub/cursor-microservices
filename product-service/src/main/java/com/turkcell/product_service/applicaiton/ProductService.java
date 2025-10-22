package com.turkcell.product_service.applicaiton;

import com.turkcell.product_service.applicaiton.dto.CreateProductRequest;
import com.turkcell.product_service.applicaiton.dto.ProductResponse;
import com.turkcell.product_service.applicaiton.dto.UpdateProductRequest;
import com.turkcell.product_service.applicaiton.usecases.*;

import java.util.List;

public class ProductService implements ProductServicePort {
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;

    public ProductService(CreateProductUseCase createProductUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase, GetProductByIdUseCase getProductByIdUseCase, GetAllProductsUseCase getAllProductsUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.getProductByIdUseCase = getProductByIdUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
    }

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
      return   createProductUseCase.execute(request);
    }

    @Override
    public ProductResponse getProductById(String id) {
       return getProductByIdUseCase.entityToProductResponse(id);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return getAllProductsUseCase.handle();
    }

    @Override
    public ProductResponse updateProduct(String id, UpdateProductRequest request) {
        return updateProductUseCase.handle(id, request);
    }

    @Override
    public void deleteProduct(String id) {
            deleteProductUseCase.execute(id);
    }
}
