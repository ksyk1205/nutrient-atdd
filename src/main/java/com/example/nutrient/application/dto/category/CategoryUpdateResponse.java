package com.example.nutrient.application.dto.category;

import com.example.nutrient.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateResponse {
    private UUID id;
    private String name;
    private int depth;


    public static CategoryUpdateResponse of(Category category) {
        CategoryUpdateResponse response = new CategoryUpdateResponse(
                category.getId(),
                category.getName(),
                category.getDepth()
        );
        return response;
    }
}
