package com.grupo.acert.temperature.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultErrorResponse {
    private String service;
    private String description;
}
