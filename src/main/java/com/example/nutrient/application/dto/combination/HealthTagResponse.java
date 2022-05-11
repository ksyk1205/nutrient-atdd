package com.example.nutrient.application.dto.combination;

import lombok.Getter;

import java.util.UUID;

@Getter
public class HealthTagResponse {
    private UUID id;
    private String name;

    public HealthTagResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
