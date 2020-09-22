package com.grupo.acert.temperature.v1.check.restclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherMapResponseDTO {
    private String name;
    private Long id;
    private Integer cod;
    private OpenWeatherMapMainResponseDTO main;
}
