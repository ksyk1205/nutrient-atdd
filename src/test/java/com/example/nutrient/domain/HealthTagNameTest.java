package com.example.nutrient.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HealthTagNameTest {
    @DisplayName("건강 상태 이름을 생성한다")
    @Test
    void create() {
        assertThatCode(() -> new HealthTagName("무기력증"))
                .doesNotThrowAnyException();
    }

    @DisplayName("건강상태 이름은 비어있지 않아야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createNullAndEmpty(String name) {
        assertThatThrownBy(() -> new HealthTagName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
