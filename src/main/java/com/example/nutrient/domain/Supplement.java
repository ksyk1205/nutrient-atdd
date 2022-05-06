package com.example.nutrient.domain;

import com.example.nutrient.application.dto.supplement.SupplementCreateResponse.CategoryResponse;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplement {

    @Id
    @Column(name = "id", columnDefinition = "varbinary(16)")
    private String id;

    private String name;
    private String content;
    private String intake;
    private String precautions;

    //private Category category;
}
