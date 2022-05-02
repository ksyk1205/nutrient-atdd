package com.example.nutrient.application.dto.supplement;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplementCreateRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String content;

    @NotEmpty
    private String intake;

    @NotEmpty
    private String precautions;

    @NotEmpty
    private String categoryId;

}
