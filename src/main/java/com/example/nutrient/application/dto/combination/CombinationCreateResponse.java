package com.example.nutrient.application.dto.combination;

import com.example.nutrient.application.dto.supplement.SupplementCreateResponse;
import com.example.nutrient.domain.Gender;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CombinationCreateResponse {
    private UUID id;
    private String title;
    private String content;
    private List<SupplementCreateResponse> supplementResponses;
    private Gender recommendedGender;
    private HealthStatusResponse healthStatusResponse;

    public CombinationCreateResponse(
            UUID id,
            String title,
            String content,
            List<SupplementCreateResponse> supplementResponses,
            Gender recommendedGender,
            HealthStatusResponse healthStatusResponse) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.supplementResponses = supplementResponses;
        this.recommendedGender = recommendedGender;
        this.healthStatusResponse = healthStatusResponse;
    }
}
