package com.grupo.acert.temperature.v1.converter.service.converters;

import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterBO;
import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;

public interface TemperatureConverter {
    TemperatureConverterBO convert(TemperatureConverterBO temperatureConverterBO);

    TemperatureScaleEnum convertTo();
}
