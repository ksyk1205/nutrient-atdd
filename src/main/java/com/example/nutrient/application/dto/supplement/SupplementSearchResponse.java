package com.example.nutrient.application.dto.supplement;

import com.example.nutrient.application.dto.supplement.SupplementUpdateResponse.CategoryResponse;
import com.example.nutrient.domain.Category;
import com.example.nutrient.domain.Supplement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplementSearchResponse {
    private UUID id;
    private String name;
    private String serialNumber;
    private LocalDate permitDate;
    private String expirationDate;
    private String intake;
    private String mainFunctional;
    private String precautions;
    private String storageWay;

    private List<LowestPriceResponse> lowestPrices = new ArrayList<>();

    private CategoryResponse category;

    public static SupplementSearchResponse of(Supplement supplement, List<LowestPriceResponse> lowestPrices) {
        return new SupplementSearchResponse(
            supplement.getId(),
            supplement.getName(),
            supplement.getSerialNumber(),
            supplement.getPermitDate(),
            supplement.getExpirationDate(),
            supplement.getIntake(),
            supplement.getMainFunctional(),
            supplement.getPrecautions(),
            supplement.getStorageWay(),
            lowestPrices,
            CategoryResponse.of(supplement.getCategory())
        );
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CategoryResponse {
        private UUID id;
        private String name;
        public static CategoryResponse of(Category category) {
            return new CategoryResponse(
                category.getId(), category.getTitle().getName()
            );
        }
    }
}
