package com.example.nutrient.infra;

import com.example.nutrient.domain.Supplement;
import com.example.nutrient.domain.repository.SupplementRepository;
import java.util.Map;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplementJpaRepository extends SupplementRepository, JpaRepository<Supplement, UUID> {
}
