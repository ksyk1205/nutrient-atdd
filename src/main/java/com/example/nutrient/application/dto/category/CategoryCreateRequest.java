package com.example.nutrient.application.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateRequest {
    @NotEmpty
    private String name;

    private Integer depth;

    public CategoryCreateRequest(String name){
        this.name = name;
    }
}
