package com.example.nutrient.domain.repository;

import com.example.nutrient.domain.Combination;
import org.springframework.stereotype.Repository;

public interface CombinationRepository {
    Combination save(Combination combination);
}
