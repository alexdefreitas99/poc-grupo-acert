package com.grupo.acert.temperature.v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends TemperatureException {

    public BadRequestException() {
        this("BadRequest");
    }

    public BadRequestException(final String description) {
        super(description);
    }

    public BadRequestException(final ErroEnum erroEnum) {
        super(erroEnum.getDescription());
    }

    public BadRequestException(final Throwable cause) {
        super(cause);
    }

    public BadRequestException(final Throwable cause, final String description) {
        super(cause, description);
    }

    public BadRequestException(final Throwable cause, final ErroEnum erroEnum) {
        super(cause, erroEnum.getDescription());
    }
}
