package com.example.nutrient.application;

import com.example.nutrient.application.dto.combination.CombinationCreateRequest;
import com.example.nutrient.application.dto.combination.CombinationCreateResponse;
import com.example.nutrient.domain.repository.CombinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CombinationService {
    private final CombinationRepository combinationRepository;

    public CombinationCreateResponse create(CombinationCreateRequest request) {
//        HealthStatus healthStatus = combinationRepository.findHealthStatusById(request.getHealthStatusId());
        return null;
    }
}
