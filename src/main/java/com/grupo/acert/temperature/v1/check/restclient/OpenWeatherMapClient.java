package com.grupo.acert.temperature.v1.check.restclient;

import com.grupo.acert.temperature.v1.check.restclient.dto.OpenWeatherMapResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class OpenWeatherMapClient {

    private final RestTemplate openWeatherMapV1;
    @Value("${api.openweather.map}")
    private String baseUrl;
    @Value("${api.openweather.map.key}")
    private String apiKey;

    public OpenWeatherMapResponseDTO checkTemperatureByCity(String city) {
        return openWeatherMapV1.getForObject(
                baseUrl + "?appid={appid}&lang={lang}&units={units}&q={city}",
                OpenWeatherMapResponseDTO.class,
                apiKey, "pt_br", "metric", city
        );
    }
}
