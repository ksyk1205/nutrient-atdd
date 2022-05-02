package com.example.nutrient.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
public class Combination {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @Embedded
    private CombinationTitle title;

    @Lob
    private String content;

    private Gender recommendedGender;

    private HealthCondition healthCondition;
}
