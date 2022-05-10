package com.example.nutrient.application;

import com.example.nutrient.application.dto.supplement.SupplementCreateRequest;
import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.application.dto.supplement.SupplementUpdateRequest;
import com.example.nutrient.application.dto.supplement.SupplementUpdateResponse;
import com.example.nutrient.domain.Supplement;
import com.example.nutrient.domain.SupplementContent;
import com.example.nutrient.domain.SupplementTitle;
import com.example.nutrient.domain.repository.SupplementRepository;
import com.example.nutrient.ui.SupplementController;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplementService {

    private final SupplementRepository supplementRepository;

    public SupplementCreateResponse create(SupplementCreateRequest request) {
        Supplement saveSupplement = supplementRepository.save(
            Supplement.builder()
                .id(UUID.randomUUID())
                .title(new SupplementTitle(request.getName()))
                .content(new SupplementContent(request.getSerialNumber(), request.getPermitDate(),
                    request.getExpirationDate(), request.getIntake(), request.getMainFunctional(),
                    request.getPrecautions(), request.getStorageWay()))
                .build());
        return SupplementCreateResponse.create(saveSupplement);
    }

    public SupplementUpdateResponse update(SupplementUpdateRequest request) {
        return null;
    }
}
