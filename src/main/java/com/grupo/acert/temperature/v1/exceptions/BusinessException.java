package com.grupo.acert.temperature.v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class BusinessException extends TemperatureException {

    public BusinessException() {
        this("Unprocessable Entity\nSomething happened during processing this entity\nThis may be interpreted usually a business error");
    }

    public BusinessException(final String description) {
        super(description);
    }

    public BusinessException(final ErroEnum erroEnum) {
        super(erroEnum.getDescription());
    }

    public BusinessException(final Throwable cause) {
        super(cause);
    }

    public BusinessException(final Throwable cause, final String description) {
        super(cause, description);
    }

    public BusinessException(final Throwable cause, final ErroEnum erroEnum) {
        super(cause, erroEnum.getDescription());
    }
}
