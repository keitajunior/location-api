package com.ekom.locationapp.specifications;

import com.ekom.locationapp.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecs {
    private static final String PRODUCT_NAME = "productName";
    private static final String PRODUCT_STATUS = "productStatus";
    private static final String PRICE = "pricePerUnit";

    private static final GenericSpecification<Product> productSpecifications = new GenericSpecification<>(Product.class);

    private ProductSpecs() throws IllegalAccessException {
        throw new IllegalAccessException("Utility Class");
    }

    public static Specification<Product> withProductStatus(String value) {
        return productSpecifications.withLike(PRODUCT_STATUS, value);
    }

    public static Specification<Product> withPrice(Long value) {
        return productSpecifications.withLike(PRICE, String.valueOf(value));
    }

}
