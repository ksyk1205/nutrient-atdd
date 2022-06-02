package com.example.nutrient.application.dto.supplement;

import com.example.nutrient.application.customvalidation.UUIDValid;
import java.time.LocalDate;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplementUpdateRequest {
    private String name;

    private String serialNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate permitDate;

    private String expirationDate;

    private String intake;

    private String mainFunctional;

    private String precautions;

    private String storageWay;

    @UUIDValid
    private UUID categoryId;
}
