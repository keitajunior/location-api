package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.SupplierDto;
import com.ekom.locationapp.entities.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {
        ProductMapper.class,
        AddressMapper.class
})
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);
    Supplier toEntity (SupplierDto supplierDto);
    @Mapping(target = "products", ignore = true)
    SupplierDto toDto(Supplier supplier);
    List<SupplierDto> toDtos(List<Supplier> entities);
}
