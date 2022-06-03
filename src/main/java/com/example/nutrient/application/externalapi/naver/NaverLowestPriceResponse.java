package com.example.nutrient.application.externalapi.naver;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NaverLowestPriceResponse {

    private List<Item> items = new ArrayList<>();

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Item{
        private String title;
        private String link;
        private Long lprice;
    }
}
