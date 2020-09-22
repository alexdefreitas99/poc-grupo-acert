package com.grupo.acert.temperature.v1.converter.service.converters;

import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterBO;
import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import org.springframework.stereotype.Component;

@Component
public class CelsiusConverter implements TemperatureConverter {

    @Override
    public TemperatureScaleEnum convertTo() {
        return TemperatureScaleEnum.CELSIUS;
    }

    @Override
    public TemperatureConverterBO convertFromKelvin(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueCelsius(temperatureConverterBO.getValue() - 273.15);
        return temperatureConverterBO;
    }

    @Override
    public TemperatureConverterBO convertFromCelsius(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueCelsius(temperatureConverterBO.getValue());
        return temperatureConverterBO;
    }

    @Override
    public TemperatureConverterBO convertFromFahrenheit(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueCelsius((temperatureConverterBO.getValue() - 32) * 5/9);
        return temperatureConverterBO;
    }
}
