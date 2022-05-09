package com.example.nutrient.domain.repository;

import com.example.nutrient.domain.Supplement;
import java.util.Optional;

public interface SupplementRepository {

    Supplement save(Supplement supplement);
}
