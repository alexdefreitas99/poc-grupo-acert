package com.grupo.acert.temperature.v1.check.restclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherMapMainResponseDTO {
    private Double temp, feels_like, temp_min, temp_max, humidity;
}
