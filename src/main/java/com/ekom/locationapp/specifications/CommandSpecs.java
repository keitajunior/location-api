package com.ekom.locationapp.specifications;

import com.ekom.locationapp.dto.CommandDto;
import com.ekom.locationapp.entities.Command;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CommandSpecs {
    public static final String COMMAND_STATUS = "commandStatus";

    public static final GenericSpecification<Command> commandSpecifications = new GenericSpecification<>(Command.class);

    private CommandSpecs() throws IllegalAccessException {
        throw new IllegalAccessException("Utility Class!");
    }

    public static Specification<Command> withStatusLike(String value) {
        return commandSpecifications.withLike(COMMAND_STATUS, value);
    }

}
