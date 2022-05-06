package com.example.nutrient.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class HealthConditionTest {
    @DisplayName("건강 상태를 생성한다")
    @Test
    void create() {
        assertThatCode(() -> new HealthCondition(UUID.randomUUID(), new HealthConditionName("무기력증")))
                .doesNotThrowAnyException();
    }
}
