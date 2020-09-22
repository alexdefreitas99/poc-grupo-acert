package com.grupo.acert.temperature.v1.check;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("Celsius Operations")
@RequestMapping("v1/check")
public class TemperatureCheckController {
    @GetMapping
    @ApiOperation(value = "Check the temperature for location and hour.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
    })
    @ResponseStatus(HttpStatus.OK)
    public String checkTemperature(@RequestBody Double a) {
        return a.toString();
    }
}
