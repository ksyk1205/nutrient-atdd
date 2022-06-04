package com.example.nutrient.application;

import com.example.nutrient.application.dto.supplement.LowestPriceResponse;
import java.util.List;

public interface LowestPriceService {

    List<LowestPriceResponse> getLowestPrices(String name);
}
