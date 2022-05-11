package com.example.nutrient.application.dto.combination;

import com.example.nutrient.domain.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CombinationCreateRequest {
    private String title;
    private String content;
    private List<UUID> combinationLineItemIds;
    private Gender recommendedGender;
    private UUID healthStatusId;

    public CombinationCreateRequest(String title, String content, List<UUID> combinationLineItemIds, Gender recommendedGender, UUID healthStatusId) {
        this.title = title;
        this.content = content;
        this.combinationLineItemIds = combinationLineItemIds;
        this.recommendedGender = recommendedGender;
        this.healthStatusId = healthStatusId;
    }

//    public Combination toCombination() {
//        return new Combination(
//                UUID.randomUUID(),
//                new CombinationTitle(title),
//                new CombinationContent(content),
//                recommendedGender,
//                new HealthStatus(new HealthStatusName())
//                )
//    }
}
