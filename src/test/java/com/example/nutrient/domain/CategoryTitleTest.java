package com.example.nutrient.domain;

import com.example.nutrient.domain.exception.CategoryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CategoryTitleTest {

    @Test
    @DisplayName("카테고리 명을 생성한다.")
    public void create(){
        assertThatCode(() -> new CategoryTitle("비타민")).doesNotThrowAnyException();
    }

    @DisplayName("카테고리 명은 비어있지 않아야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createNullAndEmpty(String name) {
        assertThatThrownBy(() -> new CategoryTitle(name))
                .isInstanceOf(CategoryException.class);
    }

}