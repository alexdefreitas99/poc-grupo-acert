package com.grupo.acert.temperature.v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends TemperatureException {
    public NotFoundException() {
        this("Not Found");
    }

    public NotFoundException(final String description) {
        super(description);
    }

    public NotFoundException(final ErroEnum erroEnum) {
        super(erroEnum.getDescription());
    }

    public NotFoundException(final Throwable cause) {
        super(cause);
    }

    public NotFoundException(final Throwable cause, final String description) {
        super(cause, description);
    }

    public NotFoundException(final Throwable cause, final ErroEnum erroEnum) {
        super(cause, erroEnum.getDescription());
    }
}
