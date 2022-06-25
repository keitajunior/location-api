package com.ekom.locationapp.services.product;

import com.ekom.locationapp.dto.ProductDto;
import com.ekom.locationapp.exceptions.ProductNotFoundException;
import com.ekom.locationapp.exceptions.SupplierNotFoundException;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);

    List<ProductDto> findListOfProduct();

    ProductDto findProductById(Long productId) throws ProductNotFoundException;

    ProductDto modifyProductById(Long productId, ProductDto productDto) throws ProductNotFoundException;

    void deleteProductById(Long productId) throws ProductNotFoundException;

    boolean exists(ProductDto productDto);

    List<ProductDto> searchByStatusOrPrice(String searchValue);

    ProductDto searchByProductName(String searchValue);
}
