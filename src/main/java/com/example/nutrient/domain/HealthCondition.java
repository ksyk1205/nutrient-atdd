package com.example.nutrient.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
public class HealthCondition {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @Embedded
    private HealthConditionName name;

    protected HealthCondition() {
    }

    public HealthCondition(UUID id, HealthConditionName name) {
        this.id = id;
        this.name = name;
    }
}
