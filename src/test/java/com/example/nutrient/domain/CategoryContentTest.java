package com.example.nutrient.domain;

import com.example.nutrient.domain.exception.CategoryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CategoryContentTest {

    @Test
    @DisplayName("카테고리 레벨을 생성한다.")
    public void create(){
        assertThatCode(() -> new CategoryContent(0)).doesNotThrowAnyException();
    }

    @DisplayName("카테고리 레벨은 0보다 같거나 높아야합니다.")
    @ParameterizedTest
    @CsvSource(value = {"-1"})
    void createNullAndEmpty(int depth) {
        assertThatThrownBy(() -> new CategoryContent(depth))
                .isInstanceOf(CategoryException.class);
    }
}