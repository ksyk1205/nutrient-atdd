package com.example.nutrient.application;

import com.example.nutrient.application.dto.combination.CombinationCreateRequest;
import com.example.nutrient.application.dto.combination.CombinationCreateResponse;
import com.example.nutrient.domain.*;
import com.example.nutrient.domain.repository.CombinationRepository;
import com.example.nutrient.domain.repository.HealthStatusRepository;
import com.example.nutrient.domain.repository.SupplementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Transactional
@RequiredArgsConstructor
@Service
public class CombinationService {
    private final CombinationRepository combinationRepository;
    private final HealthStatusRepository haHealthStatusRepository;
    private final SupplementRepository supplementRepository;

    public CombinationCreateResponse create(CombinationCreateRequest request) {
        HealthStatus healthStatus = findHealthStatusById(request.getHealthStatusId());
        Supplements supplements = findAllById(request.getSupplementIds());
        CombinationLineItems combinationLineItems = new CombinationLineItems(supplements);
        Combination saveCombination = combinationRepository.save(request.toCombination(healthStatus, combinationLineItems));
        return CombinationCreateResponse.of(saveCombination);
    }

    public HealthStatus findHealthStatusById(UUID uuid) {
        return haHealthStatusRepository
                .findById(uuid)
                .orElseThrow(EntityNotFoundException::new);
    }

    private Supplements findAllById(List<UUID> ids) {
        return new Supplements(supplementRepository.findAllById(ids));
    }
}
