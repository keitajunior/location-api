package com.ekom.locationapp.repositories;

import com.ekom.locationapp.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
