package com.example.nutrient.application.dto.supplement;

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

    @Data
    @AllArgsConstructor
    public static class CategoryResponse{
        private UUID id;
        private String name;
    }

}

