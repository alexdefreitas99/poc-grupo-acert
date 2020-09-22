package com.grupo.acert.temperature.v1.converter.service.converters;

import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterBO;
import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import org.springframework.stereotype.Component;

@Component
public class FahrenheitConverter implements TemperatureConverter {

    @Override
    public TemperatureScaleEnum convertTo() {
        return TemperatureScaleEnum.FAHRENHEIT;
    }

    @Override
    public TemperatureConverterBO convertFromKelvin(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueFahrenheit((temperatureConverterBO.getValue() - 273.15) * 9/5 + 32);
        return temperatureConverterBO;
    }

    @Override
    public TemperatureConverterBO convertFromCelsius(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueFahrenheit((temperatureConverterBO.getValue() * 9/5) + 32);
        return temperatureConverterBO;
    }

    @Override
    public TemperatureConverterBO convertFromFahrenheit(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueFahrenheit(temperatureConverterBO.getValue());
        return temperatureConverterBO;
    }
}
