package com.grupo.acert.temperature.v1.converter.service.converters;

import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterBO;
import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import org.springframework.stereotype.Component;

@Component
public class CelsiusConverter implements TemperatureConverter {

    @Override
    public TemperatureConverterBO convert(TemperatureConverterBO temperatureConverterBO) {
        return switch (temperatureConverterBO.getFromScale()) {
            case KELVIN -> convertKelvinToCelsius(temperatureConverterBO);
            case FAHRENHEIT -> convertFahrenheitToCelsius(temperatureConverterBO);
            default -> temperatureConverterBO;
        };
    }

    @Override
    public TemperatureScaleEnum convertTo() {
        return TemperatureScaleEnum.CELSIUS;
    }

    private TemperatureConverterBO convertKelvinToCelsius(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueCelsius(temperatureConverterBO.getValue() - 273.15);
        return temperatureConverterBO;
    }

    private TemperatureConverterBO convertFahrenheitToCelsius(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueCelsius((temperatureConverterBO.getValue() - 32) * 5/9);
        return temperatureConverterBO;
    }
}
