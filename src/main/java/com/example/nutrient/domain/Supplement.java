package com.example.nutrient.domain;

import com.example.nutrient.application.dto.supplement.SupplementCreateResponse.CategoryResponse;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Supplement {

    @Id
    @Column(name = "id", columnDefinition = "varbinary(16)")
    private String id;

    @Embedded
    private SupplementTitle title;

    @Embedded
    private SupplementContent content;

    //private Category category;
}
