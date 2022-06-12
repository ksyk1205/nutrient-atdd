package com.example.nutrient.application;

import com.example.nutrient.application.dto.category.CategoryCreateRequest;
import com.example.nutrient.application.dto.category.CategoryCreateResponse;
import com.example.nutrient.application.dto.category.CategoryUpdateRequest;
import com.example.nutrient.application.dto.category.CategoryUpdateResponse;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.domain.*;
import com.example.nutrient.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
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
        return CategoryCreateResponse.of(saveCategory);
    }

    public CategoryUpdateResponse update(UUID id, CategoryUpdateRequest request) {
        Category category = getCategoryById(id);

        category.updateTitle(request.getName());
        category.updateContent(request.getDepth());

        return CategoryUpdateResponse.of(category);
    }

    private Category getCategoryById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("수정하려는 카테고리의 id가 존재하지 않습니다."));
    }
}
