package com.example.nutrient.application.dto.category;

import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateResponse {
    private UUID id;
    private String name;
    private int depth;

    public static CategoryCreateResponse create(Category category) {
        CategoryCreateResponse response = new CategoryCreateResponse(category.getId(),
                category.getTitle().getName(),
                category.getContent().getDepth());
        return response;
    }
}
