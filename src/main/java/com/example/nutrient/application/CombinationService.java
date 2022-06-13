package com.example.nutrient.application;

import com.example.nutrient.application.dto.combination.CombinationCreateRequest;
import com.example.nutrient.application.dto.combination.CombinationCreateResponse;
import com.example.nutrient.application.dto.combination.CombinationUpdateRequest;
import com.example.nutrient.application.dto.combination.CombinationUpdateResponse;
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
        Supplements supplements = findAllSupplementsById(request.getSupplementIds());
        CombinationLineItems combinationLineItems = new CombinationLineItems(supplements);
        Combination saveCombination = combinationRepository.save(request.toCombination(healthStatus, combinationLineItems));
        return CombinationCreateResponse.of(saveCombination);
    }

    public HealthStatus findHealthStatusById(UUID id) {
        return haHealthStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("건강 상태를 찾을수 없습니다."));
    }

    private Supplements findAllSupplementsById(List<UUID> ids) {
        return new Supplements(supplementRepository.findAllById(ids));
    }

    public CombinationUpdateResponse update(UUID combinationId, CombinationUpdateRequest request) {
        Combination combination = findById(combinationId);
        HealthStatus healthStatus = findHealthStatusById(request.getHealthStatusId());
        Supplements supplements = findAllSupplementsById(request.getSupplementIds());
        CombinationLineItems combinationLineItems = new CombinationLineItems(supplements);

        changeCombination(combination, request, healthStatus, combinationLineItems);
        return CombinationUpdateResponse.of(combination);
    }

    private Combination findById(UUID combinationId) {
        return combinationRepository.findById(combinationId)
                .orElseThrow(() -> new EntityNotFoundException("영양제 조합을 찾을 수 없습니다."));
    }

    private void changeCombination(
            Combination combination,
            CombinationUpdateRequest request,
            HealthStatus healthStatus,
            CombinationLineItems combinationLineItems) {
        combination.changeTitle(new CombinationTitle(request.getTitle()));
        combination.changeContent(new CombinationContent(request.getContent()));
        combination.changeCombinationLineItems(combinationLineItems);
        combination.changeRecommendedTarget(request.getRecommendedGender(), healthStatus);
    }
}
