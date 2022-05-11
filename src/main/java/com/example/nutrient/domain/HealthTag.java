package com.example.nutrient.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
public class HealthTag {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @Embedded
    private HealthTagName name;

    protected HealthTag() {
    }

    public HealthTag(UUID id, HealthTagName name) {
        this.id = id;
        this.name = name;
    }
}
