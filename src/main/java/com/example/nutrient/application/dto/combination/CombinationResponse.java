package com.example.nutrient.application.dto.combination;

import com.example.nutrient.domain.Gender;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CombinationResponse {
    private UUID id;
    private String title;
    private String content;
    private List<SupplementResponse> supplementResponses;
    private Gender recommendedGender;
    private HealthConditionResponse healthConditionResponse;

    public CombinationResponse(
            UUID id,
            String title,
            String content,
            List<SupplementResponse> supplementResponses,
            Gender recommendedGender,
            HealthConditionResponse healthConditionResponse) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.supplementResponses = supplementResponses;
        this.recommendedGender = recommendedGender;
        this.healthConditionResponse = healthConditionResponse;
    }
}
