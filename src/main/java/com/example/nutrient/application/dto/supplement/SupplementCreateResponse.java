package com.example.nutrient.application.dto.supplement;

import com.example.nutrient.domain.Supplement;
import com.example.nutrient.domain.SupplementContent;
import com.example.nutrient.domain.SupplementTitle;
import java.time.LocalDate;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplementCreateResponse {

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

    public static SupplementCreateResponse create(Supplement supplement) {
        SupplementTitle title = supplement.getTitle();
        SupplementContent content = supplement.getContent();
        return new SupplementCreateResponse(
            supplement.getId(),
            title.getName(),
            content.getSerialNumber(),
            content.getPermitDate(),
            content.getExpirationDate(),
            content.getIntake(),
            content.getMainFunctional(),
            content.getPrecautions(),
            content.getStorageWay(),
            new CategoryResponse(supplement.getCategory().getId(), supplement.getCategory().getTitle().getName())
        );
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CategoryResponse {

        private UUID id;
        private String name;
    }

}

