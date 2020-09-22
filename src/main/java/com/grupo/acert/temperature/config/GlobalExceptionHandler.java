package com.grupo.acert.temperature.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final String SERVICE = "TEMP-SERV";

    @ExceptionHandler(Exception.class)
    public DefaultErrorResponse handleException(Exception e) {
        return DefaultErrorResponse
                .builder()
                .description(e.getMessage())
                .service(SERVICE)
                .build();
    }
}
