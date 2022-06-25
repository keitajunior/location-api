package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.CommandDto;
import com.ekom.locationapp.entities.Command;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-25T16:45:22+0000",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
public class CommandMapperImpl implements CommandMapper {

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Override
    public Command toEntity(CommandDto dto) {
        if ( dto == null ) {
            return null;
        }

        Command command = new Command();

        command.setId( dto.getId() );
        command.setDeliveryAddress( dto.getDeliveryAddress() );
        command.setCreatedOn( dto.getCreatedOn() );
        command.setEndDate( dto.getEndDate() );
        command.setCommandStatus( dto.getCommandStatus() );
        command.setProduct( productMapper.toEntity( dto.getProduct() ) );

        return command;
    }

    @Override
    public CommandDto toDto(Command entity) {
        if ( entity == null ) {
            return null;
        }

        CommandDto commandDto = new CommandDto();

        commandDto.setId( entity.getId() );
        commandDto.setDeliveryAddress( entity.getDeliveryAddress() );
        commandDto.setCreatedOn( entity.getCreatedOn() );
        commandDto.setEndDate( entity.getEndDate() );
        commandDto.setCommandStatus( entity.getCommandStatus() );
        commandDto.setProduct( productMapper.toDto( entity.getProduct() ) );

        return commandDto;
    }

    @Override
    public List<CommandDto> toDtos(List<Command> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CommandDto> list = new ArrayList<CommandDto>( entities.size() );
        for ( Command command : entities ) {
            list.add( toDto( command ) );
        }

        return list;
    }
}
