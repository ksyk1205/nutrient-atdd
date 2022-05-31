package com.example.nutrient.domain.repository;

import com.example.nutrient.domain.HealthStatus;
import com.example.nutrient.domain.HealthStatusName;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface HealthStatusRepository {
    Optional<HealthStatus> findById(UUID id);
}

// FIXME: JPA Repository로 변경
@Repository
class InMemoryHealthStatusRepository implements HealthStatusRepository {
    private final Map<UUID, HealthStatus> healthStatuses = new HashMap<>();

    @Override
    public Optional<HealthStatus> findById(UUID id) {
        HealthStatus status = new HealthStatus(id, new HealthStatusName("무기력"));
        healthStatuses.put(id, status);
        return Optional.ofNullable(healthStatuses.get(id));
    }
}
