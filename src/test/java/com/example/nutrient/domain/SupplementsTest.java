package com.example.nutrient.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static com.example.nutrient.domain.SupplementsFixture.*;
import static org.assertj.core.api.Assertions.*;

class SupplementsTest {
    @DisplayName("영양제 목록을 생성한다")
    @Test
    void create() {
        assertThatCode(() -> new Supplements(SUPPLEMENT_LIST))
                .doesNotThrowAnyException();
    }

    @DisplayName("영양제 목록은 비어있지 않아야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty(List<Supplement> supplements) {
        assertThatThrownBy(() -> new Supplements(supplements))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("영양제 목록이 중복이면 TRUE를 반환한다")
    @Test
    void isDuplicated() {
        // given
        Supplements supplements = createSupplements(멀티비타민_센트룸, 마그네슘_솔가, 마그네슘_솔가, 루테인_안국건강);

        // when, then
        assertThat(supplements.isDuplicated()).isTrue();
    }
}
