package com.example.nutrient.application.dto.combination;

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
}
