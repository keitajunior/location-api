package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.ProductDto;
import com.ekom.locationapp.entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-25T16:45:22+0000",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setProductName( dto.getProductName() );
        product.setProductType( dto.getProductType() );
        product.setProductStatus( dto.getProductStatus() );
        product.setImageUrl( dto.getImageUrl() );
        product.setAvailableStock( dto.getAvailableStock() );
        product.setPricePerUnit( dto.getPricePerUnit() );
        product.setOrderQuantity( dto.getOrderQuantity() );

        return product;
    }

    @Override
    public ProductDto toDto(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( entity.getId() );
        productDto.setProductName( entity.getProductName() );
        productDto.setProductType( entity.getProductType() );
        productDto.setProductStatus( entity.getProductStatus() );
        productDto.setImageUrl( entity.getImageUrl() );
        productDto.setAvailableStock( entity.getAvailableStock() );
        productDto.setPricePerUnit( entity.getPricePerUnit() );
        productDto.setOrderQuantity( entity.getOrderQuantity() );

        return productDto;
    }

    @Override
    public List<ProductDto> toDtos(List<Product> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( entities.size() );
        for ( Product product : entities ) {
            list.add( toDto( product ) );
        }

        return list;
    }
}
