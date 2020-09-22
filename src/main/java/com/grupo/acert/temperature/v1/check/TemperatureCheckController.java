package com.grupo.acert.temperature.v1.check;

import com.grupo.acert.temperature.v1.check.dto.TemperatureCheckResponse;
import com.grupo.acert.temperature.v1.check.service.TemperatureCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("Celsius Operations")
@RequestMapping("v1/check")
@RequiredArgsConstructor
public class TemperatureCheckController {

    private final TemperatureCheckService temperatureCheckService;

    @GetMapping("/{city}")
    @ApiOperation(value = "Check the temperature for city")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
    })
    @ResponseStatus(HttpStatus.OK)
    public TemperatureCheckResponse checkTemperature(@PathVariable String city) {
        return temperatureCheckService.getWeatherByCity(city);
    }
}
