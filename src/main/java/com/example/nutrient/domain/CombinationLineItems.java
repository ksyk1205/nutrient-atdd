package com.example.nutrient.domain;

import com.example.nutrient.domain.exception.CombinationLineItemDuplicatedException;
import com.example.nutrient.domain.exception.CombinationLineItemsSizeExceededException;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Embeddable
@Getter
public class CombinationLineItems {
    public static final int MAX_NUMBER_OF_ITEMS = 5;
    private static final String COMBINATION_LINE_ITEMS_MUST_NOT_BE_EMPTY = "조합 품목 목록은 비어있지 않아야 합니다.";

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "combination_id",
            nullable = false,
            columnDefinition = "varbinary(16)",
            foreignKey = @ForeignKey(name = "fk_combination_line_item_to_combination")
    )
    private List<CombinationLineItem> combinationLineItems;

    protected CombinationLineItems() {
    }

    public CombinationLineItems(List<CombinationLineItem> combinationLineItems) {
        validate(combinationLineItems);
        this.combinationLineItems = combinationLineItems;
    }

    private void validate(List<CombinationLineItem> combinationLineItems) {
        if (Objects.isNull(combinationLineItems) || combinationLineItems.isEmpty()) {
            throw new IllegalArgumentException(COMBINATION_LINE_ITEMS_MUST_NOT_BE_EMPTY);
        }
        if (isExceedMaxSize(combinationLineItems.size())) {
            throw new CombinationLineItemsSizeExceededException();
        }
        if (isDuplicated(combinationLineItems)) {
            throw new CombinationLineItemDuplicatedException();
        }
    }

    private boolean isExceedMaxSize(int size) {
        return MAX_NUMBER_OF_ITEMS < size;
    }

    private boolean isDuplicated(List<CombinationLineItem> combinationLineItems) {
        List<Supplement> supplements = combinationLineItems
                .stream().map(CombinationLineItem::getSupplement).collect(Collectors.toList());
        return new Supplements(supplements).isDuplicated();
    }
}
