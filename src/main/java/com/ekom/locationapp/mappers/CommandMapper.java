package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.CommandDto;
import com.ekom.locationapp.entities.Command;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {
        ProductMapper.class,
        AddressMapper.class
})
public interface CommandMapper {
    CommandMapper INSTANCE = Mappers.getMapper(CommandMapper.class);
    Command toEntity(CommandDto dto);
    CommandDto toDto(Command entity);
    List<CommandDto> toDtos(List<Command> entities);
}
