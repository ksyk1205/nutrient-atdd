package com.example.nutrient.application.dto.combination;

import com.example.nutrient.domain.Gender;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CombinationCreateRequest {
    private String title;
    private String content;
    private List<UUID> combinationLineItemIds;
    private Gender recommendedGender;
    private UUID healthConditionId;

    public CombinationCreateRequest(String title, String content, List<UUID> combinationLineItemIds, Gender recommendedGender, UUID healthConditionId) {
        this.title = title;
        this.content = content;
        this.combinationLineItemIds = combinationLineItemIds;
        this.recommendedGender = recommendedGender;
        this.healthConditionId = healthConditionId;
    }
}
