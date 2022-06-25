package com.ekom.locationapp.enums;

import java.util.Arrays;

public enum ProductStatus {
    NEW("Neuf"),
    GOOD_CONDITION("Bon_etat");

    private final String value;


    ProductStatus(String value) {
        this.value = value;
    }

    public  String getValue() {
        return this.value;
    }

    public static ProductStatus fromValue(String value) {
        return Arrays.stream(ProductStatus.values())
                .filter(e -> e.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }

}
