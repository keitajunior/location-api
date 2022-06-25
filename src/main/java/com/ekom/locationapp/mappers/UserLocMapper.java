package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.UserLocDto;
import com.ekom.locationapp.entities.UserLoc;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(uses = {
        AddressMapper.class
})
public interface UserLocMapper {
    UserLocMapper INSTANCE = Mappers.getMapper(UserLocMapper.class);
    UserLoc toEntity(UserLocDto dto);
    UserLocDto toDto(UserLoc entity);
    List<UserLocDto> toDtos(List<UserLoc> entities);
}
