package com.ekom.locationapp.services.supplier;

import com.ekom.locationapp.dto.SupplierDto;
import com.ekom.locationapp.exceptions.CustomerNotFoundException;
import com.ekom.locationapp.exceptions.SupplierNotFoundException;

import java.util.List;

public interface SupplierService {
    SupplierDto createSupplierAccount(SupplierDto supplierDto);

    List<SupplierDto> listOfSuppliers();

    SupplierDto findSupplierById(Long supplierId) throws SupplierNotFoundException;

    SupplierDto modifySupplierById(Long supplierId, SupplierDto supplierDto) throws SupplierNotFoundException;

    void deleteSupplierbyId(Long supplierId) throws CustomerNotFoundException;
}
