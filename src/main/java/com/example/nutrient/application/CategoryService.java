package com.example.nutrient.application;

import com.example.nutrient.application.dto.category.CategoryCreateRequest;
import com.example.nutrient.application.dto.category.CategoryCreateResponse;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.domain.*;
import com.example.nutrient.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryCreateResponse create(CategoryCreateRequest request) {
        Category saveCategory = categoryRepository.save(
                Category.builder()
                        .id(UUID.randomUUID())
                        .title(new CategoryTitle(request.getName()))
                        .content(new CategoryContent(request.getDepth()))
                        .build());
        return CategoryCreateResponse.create(saveCategory);
    }
}
