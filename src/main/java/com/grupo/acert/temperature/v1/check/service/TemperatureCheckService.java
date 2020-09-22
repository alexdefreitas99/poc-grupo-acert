package com.grupo.acert.temperature.v1.check.service;

import com.grupo.acert.temperature.v1.check.dto.TemperatureCheckResponse;
import com.grupo.acert.temperature.v1.check.restclient.OpenWeatherMapClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TemperatureCheckService {
    private final OpenWeatherMapClient openWeatherMapClient;

    public TemperatureCheckResponse getWeatherByCity(String city) {
        var openWeather = openWeatherMapClient.checkTemperatureByCity(city);

        return TemperatureCheckResponse.builder()
                .cod(openWeather.getCod())
                .id(openWeather.getId())
                .name(openWeather.getName())
                .feelsLike(openWeather.getMain().getFeels_like())
                .humidity(openWeather.getMain().getHumidity())
                .temp(openWeather.getMain().getTemp())
                .tempMax(openWeather.getMain().getTemp_max())
                .tempMin(openWeather.getMain().getTemp_min())
                .build()
                ;
    }
}
