package com.ekom.locationapp.endpoints;

public class LocationApiVersions {
    private LocationApiVersions() throws IllegalAccessException {
        throw new IllegalAccessException("utility class");
    }

    public static final String V1 = "/v1";
    public static final String V1_PRODUCTS = V1 + "/products";
    public static final String V1_COMMANDS = V1 + "/commands";
    public static final String V1_SUPPLIERS = V1 + "/suppliers";
    public static final String V1_CUSTOMERS = V1 + "/customers";
    public static final String V1_AUTH = V1 +  "/auth";
}
