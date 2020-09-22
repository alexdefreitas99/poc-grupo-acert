package com.grupo.acert.temperature.v1.converter.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureConverterRepository extends PagingAndSortingRepository<TemperatureConverterHistoricEntity, Long> {
}
