package com.grupo.acert.temperature.v1.converter.service.converters;

import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterBO;
import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import org.springframework.stereotype.Component;

@Component
public class KelvinConverter implements TemperatureConverter {

    @Override
    public TemperatureScaleEnum convertTo() {
        return TemperatureScaleEnum.KELVIN;
    }

    @Override
    public TemperatureConverterBO convertFromCelsius(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueKelvin(temperatureConverterBO.getValue() + 273.15);
        return temperatureConverterBO;
    }

    @Override
    public TemperatureConverterBO convertFromFahrenheit(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueKelvin((temperatureConverterBO.getValue() - 32) * 5/9 + 273.15);
        return temperatureConverterBO;
    }

    @Override
    public TemperatureConverterBO convertFromKelvin(TemperatureConverterBO temperatureConverterBO) {
        temperatureConverterBO.setValueKelvin(temperatureConverterBO.getValue());
        return temperatureConverterBO;
    }
}
