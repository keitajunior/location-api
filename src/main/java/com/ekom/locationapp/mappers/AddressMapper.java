package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.AddressDto;
import com.ekom.locationapp.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    Address toEntity(AddressDto dto);
    AddressDto toDto(Address entity);
}
