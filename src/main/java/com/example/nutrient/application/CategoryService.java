package com.example.nutrient.application;

import com.example.nutrient.application.dto.category.CategoryCreateRequest;
import com.example.nutrient.application.dto.category.CategoryCreateResponse;
import com.example.nutrient.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryCreateResponse create(CategoryCreateRequest request) {


        return null;
    }
}
