package com.ekom.locationapp.mappers;

import com.ekom.locationapp.dto.UserLocDto;
import com.ekom.locationapp.entities.UserLoc;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-25T16:45:21+0000",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
public class UserLocMapperImpl implements UserLocMapper {

    @Override
    public UserLoc toEntity(UserLocDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserLoc userLoc = new UserLoc();

        userLoc.setId( dto.getId() );
        userLoc.setFirstname( dto.getFirstname() );
        userLoc.setLastname( dto.getLastname() );
        userLoc.setLogin( dto.getLogin() );
        userLoc.setPassword( dto.getPassword() );
        userLoc.setPhoneNumber( dto.getPhoneNumber() );
        userLoc.setAddress( dto.getAddress() );
        userLoc.setCreatedOn( dto.getCreatedOn() );
        userLoc.setCreatedBy( dto.getCreatedBy() );
        userLoc.setLastModifyOn( dto.getLastModifyOn() );
        userLoc.setLastConnectionOn( dto.getLastConnectionOn() );

        return userLoc;
    }

    @Override
    public UserLocDto toDto(UserLoc entity) {
        if ( entity == null ) {
            return null;
        }

        UserLocDto userLocDto = new UserLocDto();

        userLocDto.setId( entity.getId() );
        userLocDto.setFirstname( entity.getFirstname() );
        userLocDto.setLastname( entity.getLastname() );
        userLocDto.setLogin( entity.getLogin() );
        userLocDto.setPassword( entity.getPassword() );
        userLocDto.setPhoneNumber( entity.getPhoneNumber() );
        userLocDto.setAddress( entity.getAddress() );
        userLocDto.setCreatedOn( entity.getCreatedOn() );
        userLocDto.setLastModifyOn( entity.getLastModifyOn() );
        userLocDto.setLastConnectionOn( entity.getLastConnectionOn() );
        userLocDto.setCreatedBy( entity.getCreatedBy() );

        return userLocDto;
    }

    @Override
    public List<UserLocDto> toDtos(List<UserLoc> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserLocDto> list = new ArrayList<UserLocDto>( entities.size() );
        for ( UserLoc userLoc : entities ) {
            list.add( toDto( userLoc ) );
        }

        return list;
    }
}
