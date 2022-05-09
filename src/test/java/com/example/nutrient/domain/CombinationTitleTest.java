package com.example.nutrient.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CombinationTitleTest {
    @DisplayName("조합 제목을 생성한다")
    @Test
    void create() {
        assertThatCode(() -> new CombinationTitle("무기력증에 추천하는 조합"))
                .doesNotThrowAnyException();
    }

    @DisplayName("조합 제목은 비어있지 않아야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createNullAndEmpty(String title) {
        assertThatThrownBy(() -> new CombinationTitle(title))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
