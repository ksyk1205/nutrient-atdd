package com.example.nutrient.application;

import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.application.dto.supplement.SupplementUpdateRequest;
import com.example.nutrient.application.dto.supplement.SupplementUpdateResponse;
import com.example.nutrient.domain.Category;
import com.example.nutrient.domain.CategoryTitle;
import com.example.nutrient.domain.Supplement;
import com.example.nutrient.domain.SupplementContent;
import com.example.nutrient.domain.SupplementTitle;
import com.example.nutrient.domain.repository.CategoryRepository;
import com.example.nutrient.domain.repository.SupplementRepository;
import java.util.Optional;
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


    public SupplementCreateResponse create(SupplementCreateRequest request) {
        Category category = getCategory(request.getCategoryId());
        Supplement saveSupplement = Supplement.builder()
            .id(UUID.randomUUID())
            .title(new SupplementTitle(request.getName()))
            .content(new SupplementContent(request.getSerialNumber(), request.getPermitDate(),
                request.getExpirationDate(), request.getIntake(), request.getMainFunctional(),
                request.getPrecautions(), request.getStorageWay()))
            .category(category)
            .build();
        supplementRepository.save(saveSupplement);
        return SupplementCreateResponse.create(saveSupplement);
    }

    public SupplementUpdateResponse update(SupplementUpdateRequest request) {
        Supplement supplement = getSupplement(request.getId());
        Category category = getCategory(request.getCategoryId());
        supplement.updateTitle(supplement.getTitle().update(request.getName()));
        supplement.updateContent(supplement.getContent().update(request.getSerialNumber(), request.getPermitDate(),
            request.getExpirationDate(), request.getIntake(), request.getMainFunctional(),
            request.getPrecautions(), request.getStorageWay()));
        supplement.updateCategory(category);
        return SupplementUpdateResponse.update(supplement);
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
