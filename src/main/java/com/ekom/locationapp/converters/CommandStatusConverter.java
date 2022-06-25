package com.ekom.locationapp.converters;

import com.ekom.locationapp.enums.CommandStatus;
import com.ekom.locationapp.enums.ProductStatus;

import javax.persistence.AttributeConverter;

public class CommandStatusConverter implements AttributeConverter<CommandStatus, String> {


    @Override
    public String convertToDatabaseColumn(CommandStatus commandStatus) {
        return commandStatus == null ? null : commandStatus.getValue();
    }

    @Override
    public CommandStatus convertToEntityAttribute(String value) {
        return value == null ? null : CommandStatus.fromValue(value);
    }
}
