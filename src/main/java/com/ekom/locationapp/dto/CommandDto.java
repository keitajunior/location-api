package com.ekom.locationapp.dto;

import com.ekom.locationapp.entities.Address;
import com.ekom.locationapp.enums.CommandStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CommandDto {
    private Long id;
    private Address deliveryAddress;
    private Long amount;
    private OffsetDateTime createdOn;
    private OffsetDateTime endDate;
    private CommandStatus commandStatus;
    private ProductDto product;
}
