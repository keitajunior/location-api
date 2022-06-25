package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.ProductDto;
import com.ekom.locationapp.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product toEntity(ProductDto dto);
    ProductDto toDto(Product entity);
    List<ProductDto> toDtos(List<Product> entities);
}
