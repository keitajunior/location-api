package com.ekom.locationapp.services.supplier;

import com.ekom.locationapp.dto.SupplierDto;
import com.ekom.locationapp.entities.Supplier;
import com.ekom.locationapp.exceptions.CustomerNotFoundException;
import com.ekom.locationapp.exceptions.SupplierNotFoundException;
import com.ekom.locationapp.handlers.SupplierHandler;
import com.ekom.locationapp.mappers.SupplierMapper;
import com.ekom.locationapp.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierDto createSupplierAccount(SupplierDto supplierDto) {
        Supplier supplier = SupplierMapper.INSTANCE.toEntity(supplierDto);
        SupplierHandler.INSTANCE.fullFillSupplierAccount(supplier);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return SupplierMapper.INSTANCE.toDto(savedSupplier);
    }

    @Override
    public List<SupplierDto> listOfSuppliers() {
        return SupplierMapper.INSTANCE.toDtos(supplierRepository.findAll());
    }

    @Override
    public SupplierDto findSupplierById(Long supplierId) throws SupplierNotFoundException {
        return SupplierMapper.INSTANCE.toDto(supplierRepository.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException("Fournisseur introuvable")));
    }

    @Override
    public SupplierDto modifySupplierById(Long supplierId, SupplierDto supplierDto) throws SupplierNotFoundException {
        Supplier foundSupplier = this.supplierRepository.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException("Fournisseur introuvable"));
        Supplier updatedSupplier =  SupplierMapper.INSTANCE.toEntity(supplierDto);
        SupplierHandler.INSTANCE.updateSupplierAccount(foundSupplier, updatedSupplier);
        Supplier savedSupplier = supplierRepository.save(foundSupplier);
        return SupplierMapper.INSTANCE.toDto(savedSupplier);
    }

    @Override
    public void deleteSupplierbyId(Long supplierId) throws CustomerNotFoundException {
        supplierRepository.findById(supplierId)
                .orElseThrow(() -> new CustomerNotFoundException("Client non trouvé"));
        supplierRepository.deleteById(supplierId);
    }
}
