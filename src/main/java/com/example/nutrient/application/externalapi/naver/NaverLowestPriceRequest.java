package com.example.nutrient.application.externalapi.naver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NaverLowestPriceRequest {
    private String query;
    private Integer display;
    private Integer start;
    private String sort;

    public static NaverLowestPriceRequest of(String name) {
        return new NaverLowestPriceRequest(name, 10, 1, "dsc");
    }

    public MultiValueMap<String, String> toMultiValueMap() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);
        return map;
    }
}
