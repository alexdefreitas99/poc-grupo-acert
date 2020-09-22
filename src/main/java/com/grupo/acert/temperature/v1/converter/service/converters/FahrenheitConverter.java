package com.grupo.acert.temperature.v1.converter.service.converters;

import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterBO;
import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import org.springframework.stereotype.Component;

@Component
public class FahrenheitConverter implements TemperatureConverter {

    @Override
    public TemperatureConverterBO convert(TemperatureConverterBO temperatureConverterBO) {
        return switch (temperatureConverterBO.getFromScale()) {
            case KELVIN -> convertKelvinToFahrenheit(temperatureConverterBO);
            case CELSIUS -> convertCelsiusToFahrenheit(temperatureConverterBO);
            default -> temperatureConverterBO;
        };
    }

    @Override
    public TemperatureScaleEnum convertTo() {
        return TemperatureScaleEnum.FAHRENHEIT;
    }

    private TemperatureConverterBO convertKelvinToFahrenheit(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueFahrenheit((temperatureConverterBO.getValue() - 273.15) * 9/5 + 32);
        return temperatureConverterBO;
    }

    private TemperatureConverterBO convertCelsiusToFahrenheit(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueFahrenheit((temperatureConverterBO.getValue() * 9/5) + 32);
        return temperatureConverterBO;
    }
}
