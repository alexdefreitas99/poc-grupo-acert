package com.grupo.acert.temperature.v1.converter.service.converters;

import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterBO;
import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import org.springframework.stereotype.Component;

@Component
public class KelvinConverter implements TemperatureConverter {

    @Override
    public TemperatureConverterBO convert(TemperatureConverterBO temperatureConverterBO) {
        return switch (temperatureConverterBO.getFromScale()) {
            case CELSIUS -> convertCelsiusToKelvin(temperatureConverterBO);
            case FAHRENHEIT -> convertFahrenheitToKelvin(temperatureConverterBO);
            default -> temperatureConverterBO;
        };
    }

    @Override
    public TemperatureScaleEnum convertTo() {
        return TemperatureScaleEnum.KELVIN;
    }

    private TemperatureConverterBO convertCelsiusToKelvin(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueKelvin(temperatureConverterBO.getValue() + 273.15);
        return temperatureConverterBO;
    }

    private TemperatureConverterBO convertFahrenheitToKelvin(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueKelvin((temperatureConverterBO.getValue() - 32) * 5/9 + 273.15);
        return temperatureConverterBO;
    }
}
