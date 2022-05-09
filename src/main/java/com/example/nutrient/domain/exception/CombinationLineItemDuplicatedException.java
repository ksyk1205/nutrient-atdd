package com.example.nutrient.domain.exception;

public class CombinationLineItemDuplicatedException extends BusinessException {
    public CombinationLineItemDuplicatedException() {
        super(ErrorCode.COMBINATION_LINE_ITEM_DUPLICATE);
    }
}
