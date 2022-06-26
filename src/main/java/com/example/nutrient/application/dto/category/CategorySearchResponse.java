package com.example.nutrient.application.dto.category;

import com.example.nutrient.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorySearchResponse {
    private UUID id;
    private String name;
    private int depth;

    public static CategorySearchResponse of(Category category) {
        CategorySearchResponse response = new CategorySearchResponse(category.getId(),
                category.getTitle().getName(),
                category.getContent().getDepth());
        return response;
    }

}
