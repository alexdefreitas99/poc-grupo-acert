package com.grupo.acert.temperature.v1.converter;

import com.grupo.acert.temperature.v1.converter.dto.TemperatureConverterRequest;
import com.grupo.acert.temperature.v1.converter.repo.TemperatureConverterHistoricEntity;

class TemperatureConverterStub {
    static TemperatureConverterHistoricEntity mockTemperatureConvertEntity() {
        return TemperatureConverterHistoricEntity
                .builder()
                .valueFahrenheit(1.9)
                .valueCelsius(2.0)
                .valueKelvin(3.0)
                .value(1)
                .build();
    }

    static String mockTemperatureConverterRequest() {
        return "{\"fromScale\":\"CELSIUS\",\"value\":1.0,\"toScale\":[\"KELVIN\"]}";
    }
}
