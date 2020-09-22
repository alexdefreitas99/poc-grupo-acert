package com.grupo.acert.temperature.v1.converter.dto;

import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TemperatureConverterRequest {
    @ApiModelProperty(value = "A escala a ser convertida", required = true)
    private final TemperatureScaleEnum fromScale;
    @ApiModelProperty(value = "O valor a ser convertido", example = "Legislative proposals.", required = true)
    private final double value;
    @ApiModelProperty(value = "Para qual escala converter", example = "Legislative proposals.", required = true)
    private final List<TemperatureScaleEnum> toScale;
}
