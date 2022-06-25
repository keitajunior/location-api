package com.ekom.locationapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class AddressDto {
    private Long id;
    private String city;
    private String label;
    private String country;
}
