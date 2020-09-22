package com.grupo.acert.temperature.v1.converter.service.converters;

import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterBO;
import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;

public interface TemperatureConverter {
    default TemperatureConverterBO convert(TemperatureConverterBO temperatureConverterBO) {
        return switch (temperatureConverterBO.getFromScale()) {
            case KELVIN -> convertFromKelvin(temperatureConverterBO);
            case FAHRENHEIT -> convertFromFahrenheit(temperatureConverterBO);
            case CELSIUS -> convertFromCelsius(temperatureConverterBO);
            default -> temperatureConverterBO;
        };
    }

    TemperatureScaleEnum convertTo();

    TemperatureConverterBO convertFromFahrenheit(TemperatureConverterBO temperatureConverterBO);

    TemperatureConverterBO convertFromCelsius(TemperatureConverterBO temperatureConverterBO);

    TemperatureConverterBO convertFromKelvin(TemperatureConverterBO temperatureConverterBO);
}
