package com.grupo.acert.temperature.v1.converter.repo;

import com.grupo.acert.temperature.v1.utils.TemperatureScaleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "temperatureConverterHistoric")
public class TemperatureConverterHistoricEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TemperatureScaleEnum fromScale;
    private double value;
    private Double valueKelvin;
    private Double valueFahrenheit;
    private Double valueCelsius;
    @CreationTimestamp
    private LocalDateTime creationDate;
}
