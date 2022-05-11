package com.example.nutrient.domain.repository;

import com.example.nutrient.domain.Supplement;
import java.util.Optional;
import java.util.UUID;

public interface SupplementRepository {

    Supplement save(Supplement supplement);

    Optional<Supplement> findById(UUID id);
}
