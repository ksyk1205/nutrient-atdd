package com.example.nutrient.domain.repository;

import com.example.nutrient.domain.Combination;

import java.util.Optional;
import java.util.UUID;

public interface CombinationRepository {
    Combination save(Combination combination);

    Optional<Combination> findById(UUID id);
}
