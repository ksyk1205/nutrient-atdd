package com.example.nutrient.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
public class HealthStatus {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @Embedded
    private HealthStatusName name;

    protected HealthStatus() {
    }

    public HealthStatus(UUID id, HealthStatusName name) {
        this.id = id;
        this.name = name;
    }
}
