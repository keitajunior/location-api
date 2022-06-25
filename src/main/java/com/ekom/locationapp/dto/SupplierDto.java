package com.ekom.locationapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SupplierDto extends UserLocDto {
    private String enterpriseName;
    private List<ProductDto> products;
}
