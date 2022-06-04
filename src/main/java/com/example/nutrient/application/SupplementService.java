package com.example.nutrient.application;

import com.example.nutrient.application.dto.supplement.LowestPriceResponse;
import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.application.dto.supplement.SupplementSearchResponse;
import com.example.nutrient.application.dto.supplement.SupplementUpdateRequest;
import com.example.nutrient.application.dto.supplement.SupplementUpdateResponse;
import com.example.nutrient.domain.Category;
import com.example.nutrient.domain.Supplement;
import com.example.nutrient.domain.SupplementContent;
import com.example.nutrient.domain.SupplementTitle;
import com.example.nutrient.domain.repository.CategoryRepository;
import com.example.nutrient.domain.repository.SupplementRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplementService {

    private final SupplementRepository supplementRepository;
    private final CategoryRepository categoryRepository;

    private final LowestPriceService lowestPriceService;

    public SupplementSearchResponse search(UUID id) {
        Supplement supplement = getSupplementAndCategory(id);
        List<LowestPriceResponse> lowestPrices = lowestPriceService.getLowestPrices(supplement.getName());
        SupplementSearchResponse response = SupplementSearchResponse.of(supplement, lowestPrices);
        return response;
    }


    public SupplementCreateResponse create(SupplementCreateRequest request) {
        Category category = getCategory(request.getCategoryId());
        Supplement supplement = Supplement.builder()
            .id(UUID.randomUUID())
            .title(new SupplementTitle(request.getName()))
            .content(new SupplementContent(request.getSerialNumber(), request.getPermitDate(),
                request.getExpirationDate(), request.getIntake(), request.getMainFunctional(),
                request.getPrecautions(), request.getStorageWay()))
            .category(category)
            .build();
        Supplement saveSupplement = supplementRepository.save(supplement);
        return SupplementCreateResponse.of(saveSupplement);
    }

    public SupplementUpdateResponse update(UUID id, SupplementUpdateRequest request) {
        Supplement supplement = getSupplement(id);
        Category category = getCategory(request.getCategoryId());
        supplement.updateTitle(new SupplementTitle(request.getName()));
        supplement.updateContent(new SupplementContent(request.getSerialNumber(), request.getPermitDate(),
            request.getExpirationDate(), request.getIntake(), request.getMainFunctional(),
            request.getPrecautions(), request.getStorageWay()));
        supplement.updateCategory(category);
        return SupplementUpdateResponse.of(supplement);
    }

    public void delete(UUID id) {
        supplementRepository.deleteById(id);
    }

    private Supplement getSupplementAndCategory(UUID id) {
        return supplementRepository.findByIdAndCategory(id)
            .orElseThrow(() -> new IllegalArgumentException("영양제가 없습니다."));
    }

    private Supplement getSupplement(UUID id) {
        return supplementRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("영양제가 없습니다."));
    }

    private Category getCategory(UUID categoryId) {
        return categoryRepository.findById(categoryId)
            .orElseThrow(() -> new IllegalArgumentException("카테고리가 없습니다."));
    }

}
