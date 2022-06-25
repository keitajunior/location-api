package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.ProductDto;
import com.ekom.locationapp.dto.SupplierDto;
import com.ekom.locationapp.entities.Product;
import com.ekom.locationapp.entities.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-25T16:45:22+0000",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
public class SupplierMapperImpl implements SupplierMapper {

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Override
    public Supplier toEntity(SupplierDto supplierDto) {
        if ( supplierDto == null ) {
            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setId( supplierDto.getId() );
        supplier.setFirstname( supplierDto.getFirstname() );
        supplier.setLastname( supplierDto.getLastname() );
        supplier.setLogin( supplierDto.getLogin() );
        supplier.setPassword( supplierDto.getPassword() );
        supplier.setPhoneNumber( supplierDto.getPhoneNumber() );
        supplier.setAddress( supplierDto.getAddress() );
        supplier.setCreatedOn( supplierDto.getCreatedOn() );
        supplier.setCreatedBy( supplierDto.getCreatedBy() );
        supplier.setLastModifyOn( supplierDto.getLastModifyOn() );
        supplier.setLastConnectionOn( supplierDto.getLastConnectionOn() );
        supplier.setEnterpriseName( supplierDto.getEnterpriseName() );
        supplier.setProducts( productDtoListToProductList( supplierDto.getProducts() ) );

        return supplier;
    }

    @Override
    public SupplierDto toDto(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierDto supplierDto = new SupplierDto();

        supplierDto.setId( supplier.getId() );
        supplierDto.setFirstname( supplier.getFirstname() );
        supplierDto.setLastname( supplier.getLastname() );
        supplierDto.setLogin( supplier.getLogin() );
        supplierDto.setPassword( supplier.getPassword() );
        supplierDto.setPhoneNumber( supplier.getPhoneNumber() );
        supplierDto.setAddress( supplier.getAddress() );
        supplierDto.setCreatedOn( supplier.getCreatedOn() );
        supplierDto.setLastModifyOn( supplier.getLastModifyOn() );
        supplierDto.setLastConnectionOn( supplier.getLastConnectionOn() );
        supplierDto.setCreatedBy( supplier.getCreatedBy() );
        supplierDto.setEnterpriseName( supplier.getEnterpriseName() );

        return supplierDto;
    }

    @Override
    public List<SupplierDto> toDtos(List<Supplier> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SupplierDto> list = new ArrayList<SupplierDto>( entities.size() );
        for ( Supplier supplier : entities ) {
            list.add( toDto( supplier ) );
        }

        return list;
    }

    protected List<Product> productDtoListToProductList(List<ProductDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<Product>( list.size() );
        for ( ProductDto productDto : list ) {
            list1.add( productMapper.toEntity( productDto ) );
        }

        return list1;
    }
}
