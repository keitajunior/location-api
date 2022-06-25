package com.ekom.locationapp.repositories;

import com.ekom.locationapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product, Long> , JpaSpecificationExecutor<Product> {
    Product findByProductNameIgnoreCase(String searchValue);
}
