package com.grupo.acert.temperature.config;

import com.grupo.acert.temperature.v1.exceptions.BadRequestException;
import com.grupo.acert.temperature.v1.exceptions.BusinessException;
import com.grupo.acert.temperature.v1.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final String SERVICE = "TEMP-SERV";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultErrorResponse> handleException(Exception e) {
        var defaultErrorResponse = DefaultErrorResponse
                .builder()
                .service(SERVICE)
                .description(e.getMessage())
                .build();

        return ResponseEntity.status(getStatus(e)).body(defaultErrorResponse);
    }

    private HttpStatus getStatus(Exception e) {
        if(e instanceof HttpClientErrorException.NotFound || e instanceof NotFoundException) return HttpStatus.NOT_FOUND;
        if(e instanceof HttpClientErrorException.BadRequest || e instanceof BadRequestException) return HttpStatus.BAD_REQUEST;
        if(e instanceof BusinessException) return HttpStatus.UNPROCESSABLE_ENTITY;
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
