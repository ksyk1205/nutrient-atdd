package com.example.nutrient.application.dto.supplement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplementCreateResponse {
    private String id;
    private String name;
    private String content;
    private CategoryResponse category;

}
