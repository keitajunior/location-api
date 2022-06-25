package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.AddressDto;
import com.ekom.locationapp.entities.Address;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-25T16:45:22+0000",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toEntity(AddressDto dto) {
        if ( dto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( dto.getId() );
        address.setCity( dto.getCity() );
        address.setLabel( dto.getLabel() );
        address.setCountry( dto.getCountry() );

        return address;
    }

    @Override
    public AddressDto toDto(Address entity) {
        if ( entity == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( entity.getId() );
        addressDto.setCity( entity.getCity() );
        addressDto.setLabel( entity.getLabel() );
        addressDto.setCountry( entity.getCountry() );

        return addressDto;
    }
}
