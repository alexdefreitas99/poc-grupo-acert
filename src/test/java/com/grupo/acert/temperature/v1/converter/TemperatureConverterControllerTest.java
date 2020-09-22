package com.grupo.acert.temperature.v1.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.acert.temperature.IntegrationTest;
import com.grupo.acert.temperature.v1.converter.dto.TemperatureConverterResponse;
import com.grupo.acert.temperature.v1.converter.repo.TemperatureConverterRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Random;

import static com.grupo.acert.temperature.v1.converter.TemperatureConverterStub.mockTemperatureConverterRequest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
class TemperatureConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TemperatureConverterRepository temperatureConverterRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    void cleanRepository() {
        temperatureConverterRepository.deleteAll();
    }

    @Test
    void convert_MustReturnSuccess() throws Exception {
        var result = mockMvc.perform(
                post("/v1/converter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mockTemperatureConverterRequest())
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("valueKelvin").value(274.15))
                .andReturn();

        var temperatureConverted = objectMapper.readValue(result.getResponse().getContentAsString(), TemperatureConverterResponse.class);

        var optionalSavedTemperature = temperatureConverterRepository.findById(temperatureConverted.getId());
        Assertions.assertThat(optionalSavedTemperature).isPresent();
        var savedTemperature = optionalSavedTemperature.get();
        Assertions.assertThat(savedTemperature).isNotNull();
        Assertions.assertThat(savedTemperature.getId()).isNotNull();
        Assertions.assertThat(savedTemperature.getCreationDate()).isAfter(LocalDateTime.now().minusDays(1));
        Assertions.assertThat(savedTemperature.getValueKelvin()).isEqualTo(274.15);
    }

    @Test
    void findById_MustReturnSuccess() throws Exception {
        var savedTemperature = temperatureConverterRepository.save(TemperatureConverterStub.mockTemperatureConvertEntity());
        mockMvc.perform(get("/v1/converter/" + savedTemperature.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(savedTemperature.getId()))
                .andExpect(jsonPath("valueKelvin").value(savedTemperature.getValueKelvin()))
                .andExpect(jsonPath("valueFarenheith").value(savedTemperature.getValueFahrenheit()))
                .andExpect(jsonPath("valueCelsius").value(savedTemperature.getValueCelsius()))
                .andExpect(jsonPath("value").value(savedTemperature.getValue()))
        ;
    }

    @Test
    void findAllPageable_MustReturnSuccess() throws Exception {
        var savedTemperature = temperatureConverterRepository.save(TemperatureConverterStub.mockTemperatureConvertEntity());
        var savedTemperature2 = temperatureConverterRepository.save(TemperatureConverterStub.mockTemperatureConvertEntity());
        var savedTemperature3 = temperatureConverterRepository.save(TemperatureConverterStub.mockTemperatureConvertEntity());
        temperatureConverterRepository.save(TemperatureConverterStub.mockTemperatureConvertEntity());

        mockMvc.perform(get("/v1/converter?page=0&size=3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("content[0].id").value(savedTemperature.getId()))
                .andExpect(jsonPath("content[0].valueKelvin").value(savedTemperature.getValueKelvin()))
                .andExpect(jsonPath("content[0].valueFarenheith").value(savedTemperature.getValueFahrenheit()))
                .andExpect(jsonPath("content[0].valueCelsius").value(savedTemperature.getValueCelsius()))
                .andExpect(jsonPath("content[0].value").value(savedTemperature.getValue()))
                .andExpect(jsonPath("content[1].id").value(savedTemperature2.getId()))
                .andExpect(jsonPath("content[1].valueKelvin").value(savedTemperature2.getValueKelvin()))
                .andExpect(jsonPath("content[1].valueFarenheith").value(savedTemperature2.getValueFahrenheit()))
                .andExpect(jsonPath("content[1].valueCelsius").value(savedTemperature2.getValueCelsius()))
                .andExpect(jsonPath("content[1].value").value(savedTemperature2.getValue()))
                .andExpect(jsonPath("content[2].id").value(savedTemperature3.getId()))
                .andExpect(jsonPath("content[2].valueKelvin").value(savedTemperature3.getValueKelvin()))
                .andExpect(jsonPath("content[2].valueFarenheith").value(savedTemperature3.getValueFahrenheit()))
                .andExpect(jsonPath("content[2].valueCelsius").value(savedTemperature3.getValueCelsius()))
                .andExpect(jsonPath("content[2].value").value(savedTemperature3.getValue()))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("numberOfElements").value(3))
                .andExpect(jsonPath("size").value(3))
                .andExpect(jsonPath("totalPages").value(2))
        ;
    }

    @Test
    void findById_MustReturnNotFoundError() throws Exception {
        var id = new Random().nextInt(5);
        mockMvc.perform(get("/v1/converter/{id}", id)).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("service").value("TEMP-SERV"))
                .andExpect(jsonPath("description").value("Não foi possível localizar a temperatura de id [" + id + "]"))
        ;
    }

}