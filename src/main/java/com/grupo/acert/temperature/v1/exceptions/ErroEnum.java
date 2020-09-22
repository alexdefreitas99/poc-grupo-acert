package com.grupo.acert.temperature.v1.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErroEnum {

    CONVERSION_WAS_NOT_POSSIBLE("Não foi possível converter a temperatura"),
    TEMPERATURE_CONVERSION_HISTORIC_NOT_FOUND("Não foi possível localizar a temperatura de id [%s]");

    private final String description;

    public String getDescription() {
        return description;
    }

    public String format(Object... args) {
        return String.format(description, args);
    }
}
