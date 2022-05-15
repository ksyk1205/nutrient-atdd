package com.example.nutrient.domain.repository;

import com.example.nutrient.domain.Category;
import com.example.nutrient.domain.Supplement;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    Optional<Category> findById(UUID id);

    Category save(Category category);
    }
