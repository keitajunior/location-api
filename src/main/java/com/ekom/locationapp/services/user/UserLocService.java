package com.ekom.locationapp.services.user;

import com.ekom.locationapp.dto.UserLocDto;

import java.util.List;

public interface UserLocService {
    boolean exists(UserLocDto userDto);

    List<UserLocDto> searchByFirstnameOrLastname(String searchValue);
}
