package com.ekom.locationapp.endpoints.v1;

import com.ekom.locationapp.dto.SupplierDto;
import com.ekom.locationapp.endpoints.LocationApiVersions;
import com.ekom.locationapp.exceptions.CustomerNotFoundException;
import com.ekom.locationapp.exceptions.SupplierNotFoundException;
import com.ekom.locationapp.services.supplier.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(LocationApiVersions.V1_SUPPLIERS)
public class SupplierEndpoint {
    private final SupplierService supplierService;

    public SupplierEndpoint(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public SupplierDto addSupplierAccount(@RequestBody SupplierDto supplierDto) {
        return supplierService.createSupplierAccount(supplierDto);
    }

    @GetMapping
    List<SupplierDto> getSuppliers() {
        return supplierService.listOfSuppliers();
    }

    @GetMapping("/{supplierId}")
    public SupplierDto getSupplier(@PathVariable Long supplierId) throws SupplierNotFoundException {
        return supplierService.findSupplierById(supplierId);
    }

    @PutMapping("/{supplierId}")
    public SupplierDto updateSupplier(@PathVariable Long supplierId, @RequestBody SupplierDto supplierDto) throws SupplierNotFoundException {
        return supplierService.modifySupplierById(supplierId, supplierDto);
    }

    @DeleteMapping("/{supplierId}")
    public void deleteSupplierAccount(@PathVariable Long supplierId) throws CustomerNotFoundException {
        supplierService.deleteSupplierbyId(supplierId);
    }
}
