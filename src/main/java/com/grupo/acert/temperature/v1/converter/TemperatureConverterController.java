package com.grupo.acert.temperature.v1.converter;

import com.grupo.acert.temperature.v1.converter.dto.TemperatureConverterRequest;
import com.grupo.acert.temperature.v1.converter.dto.TemperatureConverterResponse;
import com.grupo.acert.temperature.v1.converter.mapper.TemperatureConverterMapper;
import com.grupo.acert.temperature.v1.converter.service.TemperatureConverterService;
import com.grupo.acert.temperature.v1.exceptions.BadRequestException;
import com.grupo.acert.temperature.v1.exceptions.ErroEnum;
import com.grupo.acert.temperature.v1.exceptions.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Temperature conversions operations", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"All operations are saved in DB"})
@RequestMapping("v1/converter")
@AllArgsConstructor
public class TemperatureConverterController {

    private final TemperatureConverterService temperatureConverterService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Convert temperature and save.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Created"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public TemperatureConverterResponse convertCelsiusToFahrenheit(@RequestBody TemperatureConverterRequest converterRequest) {
        return temperatureConverterService.convert(TemperatureConverterMapper.mapFrom(converterRequest))
                .map(TemperatureConverterMapper::mapFrom)
                .orElseThrow(() -> new BadRequestException(ErroEnum.CONVERSION_WAS_NOT_POSSIBLE));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find all temperature conversion historic.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "OK"),
    })
    @ResponseStatus(HttpStatus.OK)
    public Page<TemperatureConverterResponse> findAllTemperatureConversionHistoric(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return temperatureConverterService.findAll(PageRequest.of(page, size))
                .map(TemperatureConverterMapper::mapFrom);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find temperature conversion historic by id.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 404, message = "Temperature conversion historic not found.", response = NotFoundException.class)
    })
    @ResponseStatus(HttpStatus.OK)
    public TemperatureConverterResponse findById(@PathVariable Long id) {
        return temperatureConverterService.findById(id)
                .map(TemperatureConverterMapper::mapFrom)
                .orElseThrow(() -> new NotFoundException(ErroEnum.TEMPERATURE_CONVERSION_HISTORIC_NOT_FOUND.format(id)));
    }
}
