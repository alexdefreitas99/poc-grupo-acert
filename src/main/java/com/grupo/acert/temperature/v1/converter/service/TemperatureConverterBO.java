package com.grupo.acert.temperature.v1.converter.service;

import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TemperatureConverterBO {
    private Long id;
    private TemperatureScaleEnum fromScale;
    private double value;
    private List<TemperatureScaleEnum> toScale;
    private Double valueKelvin;
    private Double valueFahrenheit;
    private Double valueCelsius;
}
