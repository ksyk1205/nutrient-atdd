package com.example.nutrient.application.dto.supplement;

import java.time.LocalDate;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplementCreateRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String serialNumber;

    @NotEmpty
    private LocalDate permitDate;

    @NotEmpty
    private String expirationDate;

    @NotEmpty
    private String intake;

    @NotEmpty
    private String mainFunctional;

    @NotEmpty
    private String precautions;

    private String storageWay;

    @NotEmpty
    private UUID categoryId;

}
