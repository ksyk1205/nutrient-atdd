package com.example.nutrient.infra;

import com.example.nutrient.domain.Supplement;
import com.example.nutrient.domain.repository.SupplementRepository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import org.springframework.data.jpa.repository.Query;

public interface SupplementJpaRepository extends SupplementRepository, JpaRepository<Supplement, UUID> {
    @Query("select s from Supplement s join fetch s.category")
    Optional<Supplement> findByIdAndCategory(UUID id);

    @Query(value = "select s from Supplement s join fetch s.category",
        countQuery = "select count(s) from Supplement s"
    )
    Page<Supplement> findAllWithCategory(Pageable page);
}
