package com.grupo.acert.temperature.v1.converter.service;

import com.grupo.acert.temperature.v1.converter.mapper.TemperatureConverterMapper;
import com.grupo.acert.temperature.v1.converter.repo.TemperatureConverterHistoricEntity;
import com.grupo.acert.temperature.v1.converter.repo.TemperatureConverterRepository;
import com.grupo.acert.temperature.v1.converter.service.converters.TemperatureConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.grupo.acert.temperature.v1.converter.mapper.TemperatureConverterMapper.mapFrom;
import static com.grupo.acert.temperature.v1.converter.mapper.TemperatureConverterMapper.mapHistoricEntity;

@Service
@RequiredArgsConstructor
public class TemperatureConverterService {

    private final TemperatureConverterRepository temperatureConverterRepository;
    private final List<TemperatureConverter> converters;

    public Optional<TemperatureConverterBO> convert(TemperatureConverterBO temperatureConverterBO) {
        for (TemperatureConverter converter : converters) {
            if (temperatureConverterBO.getToScale().contains(converter.convertTo())) {
                converter.convert(temperatureConverterBO);
            }
        }

        var entity = saveHistoric(temperatureConverterBO);

        return Optional.of(mapFrom(entity));
    }

    private TemperatureConverterHistoricEntity saveHistoric(TemperatureConverterBO temperatureConverterBO) {
        return temperatureConverterRepository
                .save(mapHistoricEntity(temperatureConverterBO));
    }

    public Page<TemperatureConverterBO> findAll(PageRequest pageRequest) {
        return temperatureConverterRepository.findAll(pageRequest)
                .map(TemperatureConverterMapper::mapFrom);
    }

    public Optional<TemperatureConverterBO> findById(Long id) {
        return temperatureConverterRepository.findById(id)
                .map(TemperatureConverterMapper::mapFrom);
    }
}
