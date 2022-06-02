package com.example.nutrient.application.dto.combination;

import com.example.nutrient.domain.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CombinationUpdateRequest {
    private String title;
    private String content;
    private List<UUID> supplementIds;
    private Gender recommendedGender;
    private UUID healthStatusId;

    public CombinationUpdateRequest(String title, String content, List<UUID> supplementIds, Gender recommendedGender, UUID healthStatusId) {
        this.title = title;
        this.content = content;
        this.supplementIds = supplementIds;
        this.recommendedGender = recommendedGender;
        this.healthStatusId = healthStatusId;
    }
}
