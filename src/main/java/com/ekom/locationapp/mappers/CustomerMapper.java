package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.CustomerDto;
import com.ekom.locationapp.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {
        CommandMapper.class,
        AddressMapper.class
})
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer toEntity(CustomerDto dto);
    @Mapping(target = "commands", ignore = true)
    CustomerDto toDto(Customer entity);
    List<CustomerDto> toDtos(List<Customer> entities);
}
