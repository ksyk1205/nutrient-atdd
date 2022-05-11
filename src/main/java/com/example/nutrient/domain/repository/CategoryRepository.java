package com.example.nutrient.domain.repository;

import com.example.nutrient.domain.Category;
import com.example.nutrient.domain.Supplement;

public interface CategoryRepository {
    Category save(Category category);
}
