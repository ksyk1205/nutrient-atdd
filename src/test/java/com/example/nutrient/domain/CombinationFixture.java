package com.example.nutrient.domain;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.nutrient.domain.SupplementsFixture.*;

public class CombinationFixture {
    public static final UUID COMBINATION_ID;
    public static final CombinationTitle COMBINATION_TITLE;
    public static final CombinationContent COMBINATION_CONTENT;
    public static final Gender RECOMMENDED_GENDER;
    public static final HealthStatusName HEALTH_STATUS_NAME;
    public static final HealthStatus HEALTH_STATUS;
    public static final List<CombinationLineItem> COMBINATION_LINE_ITEM_LIST;
    public static final CombinationLineItems COMBINATION_LINE_ITEMS;

    static {
        COMBINATION_ID = UUID.randomUUID();
        COMBINATION_TITLE = new CombinationTitle("무기력증에 추천");
        COMBINATION_CONTENT = new CombinationContent("<p>일상이 무기력할 때 추천하는 영양제 조합입니다.<p>");
        RECOMMENDED_GENDER = Gender.ALL;
        HEALTH_STATUS_NAME = new HealthStatusName("무기력");
        HEALTH_STATUS = new HealthStatus(UUID.randomUUID(), HEALTH_STATUS_NAME);
        COMBINATION_LINE_ITEM_LIST = Arrays.asList(
                new CombinationLineItem(멀티비타민_센트룸),
                new CombinationLineItem(마그네슘_솔가),
                new CombinationLineItem(루테인_안국건강),
                new CombinationLineItem(밀크시슬_나우푸드),
                new CombinationLineItem(오메가3_종근당)
        );
        COMBINATION_LINE_ITEMS = new CombinationLineItems(COMBINATION_LINE_ITEM_LIST);
    }

    public static List<CombinationLineItem> createCombinationLineItemList(Supplement... supplements) {
        return Arrays.stream(supplements)
                .map(CombinationLineItem::new)
                .collect(Collectors.toList());
    }
}
