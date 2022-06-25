package com.ekom.locationapp.services.product;

import com.ekom.locationapp.dto.ProductDto;
import com.ekom.locationapp.entities.Product;
import com.ekom.locationapp.exceptions.ProductNotFoundException;
import com.ekom.locationapp.handlers.ProductHandler;
import com.ekom.locationapp.mappers.ProductMapper;
import com.ekom.locationapp.repositories.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ekom.locationapp.specifications.ProductSpecs.withPrice;
import static com.ekom.locationapp.specifications.ProductSpecs.withProductStatus;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product newProduct = ProductMapper.INSTANCE.toEntity(productDto);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.INSTANCE.toDto(savedProduct);
    }

    @Override
    public List<ProductDto> findListOfProduct() {
        return ProductMapper.INSTANCE.toDtos(productRepository.findAll());
    }

    @Override
    public ProductDto findProductById(Long productId) throws ProductNotFoundException {
        Product findingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("produit inexistant"));
        return ProductMapper.INSTANCE.toDto(findingProduct);
    }

    @Override
    public ProductDto modifyProductById(Long productId, ProductDto productDto) throws ProductNotFoundException {
        Product foundProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("mis à jour impossible car le produit n'existe pas"));

        Product productFromUi = ProductMapper.INSTANCE.toEntity(productDto);
        ProductHandler.INSTANCE.updateProduct(foundProduct, productFromUi);
        Product savedProduct = productRepository.save(foundProduct);
        return ProductMapper.INSTANCE.toDto(savedProduct);
    }


    @Override
    public void deleteProductById(Long productId) throws ProductNotFoundException {
        productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Produit impossible à supprimer car inexistant"));
        productRepository.deleteById(productId);
    }

    @Override()
    public boolean exists(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.toEntity(productDto);
        Example productExample = Example.of(product, ExampleMatcher.matching().withIgnoreNullValues());
        return this.productRepository.exists(productExample);
    }

    @Override
    public List<ProductDto> searchByStatusOrPrice(String searchValue) {
        return ProductMapper.INSTANCE.toDtos(this.productRepository.findAll(
                withProductStatus(searchValue).or(withPrice(Long.valueOf(searchValue)))));
    }

    @Override
    public ProductDto searchByProductName(String searchValue) {
        return ProductMapper.INSTANCE.toDto(this.productRepository.findByProductNameIgnoreCase(searchValue));
    }

}
