package com.example.nutrient.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.nutrient.domain.CombinationFixture.*;
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
}
