package com.ekom.locationapp.enums;

import java.util.Arrays;

public enum CommandStatus {
    DELIVERED ("Livre"),
    IN_PROGRESS ("En_cours"),
    UNAVAILABLE ("Indisponible");

    private final String value;

    CommandStatus(String value) {
        this.value = value;
    }

    public  String getValue() {
        return this.value;
    }

    public static CommandStatus fromValue(String value) {
        return Arrays.stream(CommandStatus.values())
                .filter(e -> e.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }

}
