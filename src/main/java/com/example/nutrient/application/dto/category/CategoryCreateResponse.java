package com.example.nutrient.application.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateResponse {
    private String id;
    private String name;
    private int depth;

}
