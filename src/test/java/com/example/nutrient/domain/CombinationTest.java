package com.example.nutrient.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static com.example.nutrient.domain.CombinationFixture.*;
import static com.example.nutrient.domain.SupplementsFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CombinationTest {
    @DisplayName("조합을 생성한다")
    @Test
    void create() {
        assertThatCode(() ->
                new Combination(
                        COMBINATION_ID,
                        COMBINATION_TITLE,
                        COMBINATION_CONTENT,
                        RECOMMENDED_GENDER,
                        HEALTH_STATUS,
                        COMBINATION_LINE_ITEMS))
                .doesNotThrowAnyException();
    }

    @DisplayName("조합 제목을 수정한다")
    @Test
    void changeTitle() {
        // given
        Combination combination = new Combination(
                COMBINATION_ID,
                COMBINATION_TITLE,
                COMBINATION_CONTENT,
                RECOMMENDED_GENDER,
                HEALTH_STATUS,
                COMBINATION_LINE_ITEMS);

        CombinationTitle title = new CombinationTitle("무기력증에 추천하는 조합");

        // when
        combination.changeTitle(title);

        // then
        assertThat(combination.getTitle()).isEqualTo("무기력증에 추천하는 조합");
    }

    @DisplayName("조합 내용을 수정한다")
    @Test
    void changeContent() {
        // given
        Combination combination = new Combination(
                COMBINATION_ID,
                COMBINATION_TITLE,
                COMBINATION_CONTENT,
                RECOMMENDED_GENDER,
                HEALTH_STATUS,
                COMBINATION_LINE_ITEMS);

        CombinationContent content = new CombinationContent("<h1>일상이 무기력할 때 추천하는 영양제 조합입니다.<h1>");

        // when
        combination.changeContent(content);

        // then
        assertThat(combination.getContent()).isEqualTo("<h1>일상이 무기력할 때 추천하는 영양제 조합입니다.<h1>");
    }

    @DisplayName("조합 품목을 수정한다")
    @Test
    void changeCombinationLineItems() {
        // given
        Combination combination = new Combination(
                COMBINATION_ID,
                COMBINATION_TITLE,
                COMBINATION_CONTENT,
                RECOMMENDED_GENDER,
                HEALTH_STATUS,
                COMBINATION_LINE_ITEMS);

        List<CombinationLineItem> combinationLineItemList =
                createCombinationLineItemList(마그네슘_솔가, 루테인_안국건강, 밀크시슬_나우푸드, 오메가3_종근당, 빌베리_프롬바이오);
        CombinationLineItems combinationLineItems = new CombinationLineItems(combinationLineItemList);

        // when
        combination.changeCombinationLineItems(combinationLineItems);

        // then
        assertThat(combination.getCombinationLineItems()).containsExactly(combinationLineItemList.toArray(new CombinationLineItem[0]));
    }

    @DisplayName("조합 추천대상을 수정한다")
    @Test
    void changeRecommendedTarget() {
        // given
        Combination combination = new Combination(
                COMBINATION_ID,
                COMBINATION_TITLE,
                COMBINATION_CONTENT,
                RECOMMENDED_GENDER,
                HEALTH_STATUS,
                COMBINATION_LINE_ITEMS);

        Gender gender = Gender.FEMALE;
        HealthStatus healthStatus = new HealthStatus(UUID.randomUUID(), new HealthStatusName("만성피로"));

        // when
        combination.changeRecommendedTarget(gender, healthStatus);

        // then
        assertThat(combination.getRecommendedGender()).isEqualTo(Gender.FEMALE);
        assertThat(combination.getHealthStatus().getName()).isEqualTo("만성피로");
    }
}
