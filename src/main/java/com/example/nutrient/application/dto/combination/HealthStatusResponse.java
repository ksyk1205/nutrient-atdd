package com.example.nutrient.application.dto.combination;

import com.example.nutrient.domain.HealthStatus;
import lombok.Getter;

import java.util.UUID;

@Getter
public class HealthStatusResponse {
    private UUID id;
    private String name;

    public HealthStatusResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static HealthStatusResponse of(HealthStatus healthStatus) {
        return new HealthStatusResponse(healthStatus.getId(), healthStatus.getName());
    }
}
