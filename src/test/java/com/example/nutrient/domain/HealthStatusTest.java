package com.example.nutrient.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatCode;

class HealthStatusTest {
    @DisplayName("건강 상태를 생성한다")
    @Test
    void create() {
        assertThatCode(() -> new HealthStatus(UUID.randomUUID(), new HealthStatusName("무기력증")))
                .doesNotThrowAnyException();
    }
}
