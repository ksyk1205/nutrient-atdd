package com.example.nutrient.application.dto.supplement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LowestPriceResponse {
    private String title;
    private String link;
    private Long lprice;

}
