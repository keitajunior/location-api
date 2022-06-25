package com.ekom.locationapp.handlers;

import com.ekom.locationapp.entities.Product;

public enum ProductHandler {
    INSTANCE;
    public void fullFillProduct(Product product) {
    }
    public void updateProduct(Product foundProduct, Product productFromUi) {
        if (productFromUi.getProductName() != null) foundProduct.setProductName(productFromUi.getProductName());
        if (productFromUi.getProductStatus() != null) foundProduct.setProductStatus(productFromUi.getProductStatus());
        if (productFromUi.getAvailableStock() != 0) foundProduct.setAvailableStock(productFromUi.getAvailableStock());
        if (productFromUi.getProductType() != null) foundProduct.setProductType(productFromUi.getProductType());
        if (productFromUi.getPricePerUnit() != 0) foundProduct.setPricePerUnit(productFromUi.getPricePerUnit());
        if (productFromUi.getImageUrl() != null) foundProduct.setImageUrl(productFromUi.getImageUrl());
        if (productFromUi.getSupplier() != null) foundProduct.setSupplier(productFromUi.getSupplier());
    }

}
