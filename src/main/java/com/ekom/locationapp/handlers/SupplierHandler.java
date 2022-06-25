package com.ekom.locationapp.handlers;

import com.ekom.locationapp.entities.Product;
import com.ekom.locationapp.entities.Supplier;

import java.time.OffsetDateTime;
import java.util.List;

public enum SupplierHandler {
    INSTANCE;
    public void fullFillSupplierAccount(Supplier supplier) {
        OffsetDateTime now = OffsetDateTime.now();
        supplier.setCreatedOn(now);
        supplier.setLastModifyOn(now);

        List<Product> products = supplier.getProducts();
        if (products != null && !products.isEmpty()) products.forEach(product -> product.setSupplier(supplier));
    }
    public void updateSupplierAccount(Supplier supplierFromDb, Supplier supplierFromUi) {
        if (supplierFromUi.getAddress() != null)
            supplierFromDb.setAddress(supplierFromUi.getAddress());
        if (supplierFromUi.getPhoneNumber() != null)
            supplierFromDb.setPhoneNumber(supplierFromUi.getPhoneNumber());
        if (supplierFromUi.getLogin() != null)
            supplierFromDb.setLogin(supplierFromUi.getLogin());
        if (supplierFromUi.getPassword() != null)
            supplierFromDb.setPassword(supplierFromUi.getPassword());
        if (supplierFromUi.getFirstname() != null)
            supplierFromDb.setFirstname(supplierFromUi.getFirstname());
        if (supplierFromUi.getLastname() != null)
            supplierFromDb.setLastname(supplierFromUi.getLastname());
        if (supplierFromUi.getEnterpriseName() != null)
            supplierFromDb.setEnterpriseName((supplierFromUi.getEnterpriseName()));

        List<Product> products = supplierFromUi.getProducts();
        if (products != null && !products.isEmpty()) {
            supplierFromDb.getProducts().clear();
            supplierFromDb.getProducts().addAll(products);
            supplierFromDb.getProducts().forEach(product -> product.setSupplier(supplierFromDb));
        }
        OffsetDateTime now = OffsetDateTime.now();
        supplierFromDb.setLastModifyOn(now);
    }
}
