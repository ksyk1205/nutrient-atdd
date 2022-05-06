package com.example.nutrient.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CombinationContentTest {
    @DisplayName("조합 내용을 생성한다")
    @Test
    void create() {
        assertThatCode(() -> new CombinationContent("<p>일상이 무기력할 때 추천하는 영양제 조합입니다.<p>"))
                .doesNotThrowAnyException();
    }

    @DisplayName("조합 내용은 비어있지 않아야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createNullAndEmpty(String content) {
        assertThatThrownBy(() -> new CombinationContent(content))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
