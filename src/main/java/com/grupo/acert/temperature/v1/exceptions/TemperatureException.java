package com.grupo.acert.temperature.v1.exceptions;

public class TemperatureException extends RuntimeException {

    public TemperatureException() {
        this("Internal Server Error");
    }

    public TemperatureException(final String description) {
        super(description);
    }

    public TemperatureException(final ErroEnum erroEnum) {
        this(erroEnum.getDescription());
    }

    public TemperatureException(final Throwable cause) {
        super(cause);
    }

    public TemperatureException(final Throwable cause, final String description) {
        super(description, cause);
    }

    public TemperatureException(final Throwable cause, final ErroEnum erroEnum) {
        this(cause, erroEnum.getDescription());
    }
}
