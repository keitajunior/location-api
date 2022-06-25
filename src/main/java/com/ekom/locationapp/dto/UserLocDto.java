package com.ekom.locationapp.dto;

import com.ekom.locationapp.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLocDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String phoneNumber;
    private Address address;
    private OffsetDateTime createdOn;
    private OffsetDateTime lastModifyOn;
    private OffsetDateTime lastConnectionOn;
    private String createdBy;
}
