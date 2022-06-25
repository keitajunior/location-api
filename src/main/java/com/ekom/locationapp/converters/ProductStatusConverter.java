package com.ekom.locationapp.converters;

import com.ekom.locationapp.entities.Product;
import com.ekom.locationapp.enums.ProductStatus;

import javax.persistence.AttributeConverter;

public class ProductStatusConverter implements AttributeConverter<ProductStatus, String> {


    @Override
    public String convertToDatabaseColumn(ProductStatus productStatus) {
        return productStatus == null ? null : productStatus.getValue();
    }

    @Override
    public ProductStatus convertToEntityAttribute(String value) {
        return value == null ? null : ProductStatus.fromValue(value);
    }
}
