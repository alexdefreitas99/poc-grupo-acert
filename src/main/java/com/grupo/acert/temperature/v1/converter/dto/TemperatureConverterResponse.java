package com.grupo.acert.temperature.v1.converter.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TemperatureConverterResponse {
    private final Long id;
    private final Double valueKelvin;
    private final Double valueFarenheith;
    private final Double valueCelsius;
    private final Double value;
}
