package com.example.nutrient.domain;

import com.example.nutrient.domain.exception.CombinationLineItemDuplicatedException;
import com.example.nutrient.domain.exception.CombinationLineItemsSizeExceededException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static com.example.nutrient.domain.CombinationFixture.COMBINATION_LINE_ITEM_LIST;
import static com.example.nutrient.domain.CombinationFixture.createCombinationLineItemList;
import static com.example.nutrient.domain.SupplementsFixture.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CombinationLineItemsTest {
    @DisplayName("조합 품목 목록을 생성한다")
    @Test
    void create() {
        assertThatCode(() -> new CombinationLineItems(COMBINATION_LINE_ITEM_LIST))
                .doesNotThrowAnyException();
    }

    @DisplayName("조합 품목 목록을 생성한다")
    @Test
    void createWithSupplements() {
        assertThatCode(() -> new CombinationLineItems(SUPPLEMENTS))
                .doesNotThrowAnyException();
    }

    @DisplayName("조함 품목 목록은 비어있지 않아야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty(List<CombinationLineItem> combinationLineItems) {
        assertThatThrownBy(() -> new CombinationLineItems(combinationLineItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("조합 품목 목록은 중복되지 않아야 한다")
    @Test
    void isExceedMaxSize() {
        // given
        List<CombinationLineItem> combinationLineItemList =
                createCombinationLineItemList(멀티비타민_센트룸, 마그네슘_솔가, 루테인_안국건강, 밀크시슬_나우푸드, 오메가3_종근당, 빌베리_프롬바이오);

        // when, then
        assertThatThrownBy(() -> new CombinationLineItems(combinationLineItemList))
                .isInstanceOf(CombinationLineItemsSizeExceededException.class);
    }

    @DisplayName("조합 품목 목록은 중복되지 않아야 한다")
    @Test
    void isDuplicated() {
        // given
        List<CombinationLineItem> combinationLineItemList =
                createCombinationLineItemList(멀티비타민_센트룸, 마그네슘_솔가, 마그네슘_솔가, 루테인_안국건강);

        // when, then
        assertThatThrownBy(() -> new CombinationLineItems(combinationLineItemList))
                .isInstanceOf(CombinationLineItemDuplicatedException.class);
    }
}
