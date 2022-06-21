package com.example.nutrient.domain.repository;

import com.example.nutrient.domain.Supplement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplementRepository {

    Supplement save(Supplement supplement);

    Optional<Supplement> findById(UUID id);

    List<Supplement> findAllById(Iterable<UUID> ids);

    Page<Supplement> findAllWithCategory(Pageable page);

    void deleteById(UUID id);

    Optional<Supplement> findByIdAndCategory(UUID id);

}
