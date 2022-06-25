package com.ekom.locationapp.dto;

import com.ekom.locationapp.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private String productType;
    private ProductStatus productStatus;
    private String imageUrl;
    private int availableStock;
    private int pricePerUnit;
    private int orderQuantity;
}
