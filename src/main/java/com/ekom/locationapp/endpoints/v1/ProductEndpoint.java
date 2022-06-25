package com.ekom.locationapp.endpoints.v1;

import com.ekom.locationapp.dto.ProductDto;
import com.ekom.locationapp.endpoints.LocationApiVersions;
import com.ekom.locationapp.exceptions.ProductNotFoundException;
import com.ekom.locationapp.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(LocationApiVersions.V1_PRODUCTS)
public class ProductEndpoint {

    private final ProductService productService;

    @Autowired
    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto newProductDto) {
        return this.productService.addProduct(newProductDto);
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return this.productService.findListOfProduct();
    }

    @GetMapping("/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) throws ProductNotFoundException {
        return this.productService.findProductById(productId);
    }

    @PutMapping("/{productId}")
    public ProductDto updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) throws ProductNotFoundException {
        return this.productService.modifyProductById(productId, productDto);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) throws ProductNotFoundException {
        this.productService.deleteProductById(productId);
    }

    // FONCTIONNALITÉS NON ENCORE DEVELOPPÉE

    @PostMapping("/check")
    public boolean checkIfProductExist(@RequestBody ProductDto productDto) {
        return this.productService.exists(productDto);
    }

    @PostMapping("/search")
    public List<ProductDto> searchBy(@RequestParam String searchValue) throws ProductNotFoundException {
        return this.productService.searchByStatusOrPrice(searchValue);
    }

    @PostMapping("/searchByName")
    public ProductDto searchByName(@RequestParam String searchValue) throws ProductNotFoundException {
        return this.productService.searchByProductName(searchValue);
    }
}
