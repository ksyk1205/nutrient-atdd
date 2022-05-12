package com.example.nutrient.infra;

import com.example.nutrient.domain.Combination;
import com.example.nutrient.domain.repository.CombinationRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CombinationJpaRepository extends CombinationRepository, JpaRepository<Combination, UUID> {
}
