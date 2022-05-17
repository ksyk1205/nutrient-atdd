package com.example.nutrient.infra;

import com.example.nutrient.domain.Category;
import com.example.nutrient.domain.Supplement;
import com.example.nutrient.domain.repository.CategoryRepository;
import com.example.nutrient.domain.repository.SupplementRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryJpaRepository extends CategoryRepository, JpaRepository<Category, UUID> {
}
