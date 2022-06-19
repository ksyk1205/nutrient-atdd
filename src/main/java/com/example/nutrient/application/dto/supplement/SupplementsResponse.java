package com.example.nutrient.application.dto.supplement;

import com.example.nutrient.application.dto.supplement.SupplementSearchResponse.CategoryResponse;
import com.example.nutrient.domain.Category;
import com.example.nutrient.domain.Supplement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplementsResponse {
    private UUID id;
    private String name;
    private String serialNumber;
    private LocalDate permitDate;
    private String expirationDate;
    private String intake;
    private String mainFunctional;
    private String precautions;
    private String storageWay;
    private CategoryResponse category;

    public static SupplementsResponse of(Supplement supplement) {
        return new SupplementsResponse(
            supplement.getId(),
            supplement.getName(),
            supplement.getSerialNumber(),
            supplement.getPermitDate(),
            supplement.getExpirationDate(),
            supplement.getIntake(),
            supplement.getMainFunctional(),
            supplement.getPrecautions(),
            supplement.getStorageWay(),
            SupplementsResponse.CategoryResponse.of(supplement.getCategory())
        );
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CategoryResponse {
        private UUID id;
        private String name;
        public static SupplementsResponse.CategoryResponse of(Category category) {
            return new SupplementsResponse.CategoryResponse(
                category.getId(), category.getTitle().getName()
            );
        }
    }
}
