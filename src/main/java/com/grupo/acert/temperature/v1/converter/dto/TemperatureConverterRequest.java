package com.grupo.acert.temperature.v1.converter.dto;

import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TemperatureConverterRequest {
    @ApiModelProperty(value = "${temperature.converter.request.fromScale.property}", required = true)
    private final TemperatureScaleEnum fromScale;
    @ApiModelProperty(value = "Agenda subject.", example = "Legislative proposals.", required = true)
    private final double value;
    @ApiModelProperty(value = "Agenda subject.", example = "Legislative proposals.", required = true)
    private final List<TemperatureScaleEnum> toScale;
}
