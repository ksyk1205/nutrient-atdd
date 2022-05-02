package com.example.nutrient.application.dto.supplement;

import javax.validation.constraints.NotEmpty;
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
    private String intake;
    private String precautions;

    private CategoryResponse category;

    @Data
    @AllArgsConstructor
    public static class CategoryResponse{
        private String id;
        private String name;
    }

}

