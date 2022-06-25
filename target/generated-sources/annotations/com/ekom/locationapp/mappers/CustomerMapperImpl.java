package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.CommandDto;
import com.ekom.locationapp.dto.CustomerDto;
import com.ekom.locationapp.entities.Command;
import com.ekom.locationapp.entities.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-25T16:45:22+0000",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    private final CommandMapper commandMapper = CommandMapper.INSTANCE;

    @Override
    public Customer toEntity(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( dto.getId() );
        customer.setFirstname( dto.getFirstname() );
        customer.setLastname( dto.getLastname() );
        customer.setLogin( dto.getLogin() );
        customer.setPassword( dto.getPassword() );
        customer.setPhoneNumber( dto.getPhoneNumber() );
        customer.setAddress( dto.getAddress() );
        customer.setCreatedOn( dto.getCreatedOn() );
        customer.setCreatedBy( dto.getCreatedBy() );
        customer.setLastModifyOn( dto.getLastModifyOn() );
        customer.setLastConnectionOn( dto.getLastConnectionOn() );
        customer.setCommands( commandDtoListToCommandList( dto.getCommands() ) );

        return customer;
    }

    @Override
    public CustomerDto toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( entity.getId() );
        customerDto.setFirstname( entity.getFirstname() );
        customerDto.setLastname( entity.getLastname() );
        customerDto.setLogin( entity.getLogin() );
        customerDto.setPassword( entity.getPassword() );
        customerDto.setPhoneNumber( entity.getPhoneNumber() );
        customerDto.setAddress( entity.getAddress() );
        customerDto.setCreatedOn( entity.getCreatedOn() );
        customerDto.setLastModifyOn( entity.getLastModifyOn() );
        customerDto.setLastConnectionOn( entity.getLastConnectionOn() );
        customerDto.setCreatedBy( entity.getCreatedBy() );

        return customerDto;
    }

    @Override
    public List<CustomerDto> toDtos(List<Customer> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( entities.size() );
        for ( Customer customer : entities ) {
            list.add( toDto( customer ) );
        }

        return list;
    }

    protected List<Command> commandDtoListToCommandList(List<CommandDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Command> list1 = new ArrayList<Command>( list.size() );
        for ( CommandDto commandDto : list ) {
            list1.add( commandMapper.toEntity( commandDto ) );
        }

        return list1;
    }
}
