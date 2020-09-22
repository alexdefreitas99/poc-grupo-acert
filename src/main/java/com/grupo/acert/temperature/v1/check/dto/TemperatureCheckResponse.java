package com.grupo.acert.temperature.v1.check.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemperatureCheckResponse {
    private String name;
    private Long id;
    private Integer cod;
    private Double temp, feelsLike, tempMin, tempMax, humidity;
}
