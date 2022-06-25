package com.ekom.locationapp.entities;

import com.ekom.locationapp.converters.ProductStatusConverter;
import com.ekom.locationapp.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productType;
    @Convert(converter = ProductStatusConverter.class)
    private ProductStatus productStatus;
    private String imageUrl;
    private int availableStock;
    private int pricePerUnit;
    private int orderQuantity;
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;
}
