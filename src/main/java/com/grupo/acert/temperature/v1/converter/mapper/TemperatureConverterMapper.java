package com.grupo.acert.temperature.v1.converter.mapper;

import com.grupo.acert.temperature.v1.converter.dto.TemperatureConverterRequest;
import com.grupo.acert.temperature.v1.converter.dto.TemperatureConverterResponse;
import com.grupo.acert.temperature.v1.converter.repo.TemperatureConverterHistoricEntity;
import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterBO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TemperatureConverterMapper {
    public static TemperatureConverterBO mapFrom(TemperatureConverterRequest converterRequest) {
        return TemperatureConverterBO
                .builder()
                .fromScale(converterRequest.getFromScale())
                .toScale(converterRequest.getToScale())
                .value(converterRequest.getValue())
                .build();
    }

    public static TemperatureConverterResponse mapFrom(TemperatureConverterBO temperatureConverterBO) {
        return TemperatureConverterResponse
                .builder()
                .id(temperatureConverterBO.getId())
                .valueCelsius(temperatureConverterBO.getValueCelsius())
                .valueFarenheith(temperatureConverterBO.getValueFahrenheit())
                .valueKelvin(temperatureConverterBO.getValueKelvin())
                .value(temperatureConverterBO.getValue())
                .build();
    }

    public static TemperatureConverterHistoricEntity mapHistoricEntity(TemperatureConverterBO temperatureConverterBO) {
        return TemperatureConverterHistoricEntity
                .builder()
                .valueFahrenheit(temperatureConverterBO.getValueFahrenheit())
                .valueCelsius(temperatureConverterBO.getValueCelsius())
                .valueFahrenheit(temperatureConverterBO.getValueFahrenheit())
                .valueKelvin(temperatureConverterBO.getValueKelvin())
                .value(temperatureConverterBO.getValue())
                .fromScale(temperatureConverterBO.getFromScale())
//                .toScale(temperatureConverterBO.getToScale())
                .build();
    }

    public static TemperatureConverterBO mapFrom(TemperatureConverterHistoricEntity historicEntity) {
        return TemperatureConverterBO
                .builder()
                .valueKelvin(historicEntity.getValueKelvin())
                .valueCelsius(historicEntity.getValueCelsius())
                .valueFahrenheit(historicEntity.getValueFahrenheit())
                .id(historicEntity.getId())
                .fromScale(historicEntity.getFromScale())
//                .toScale(historicEntity.getToScale())
                .value(historicEntity.getValue())
                .build();
    }

}
