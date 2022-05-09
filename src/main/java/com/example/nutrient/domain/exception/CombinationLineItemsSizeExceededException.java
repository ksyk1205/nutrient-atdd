package com.example.nutrient.domain.exception;

public class CombinationLineItemsSizeExceededException extends BusinessException {
    public CombinationLineItemsSizeExceededException() {
        super(ErrorCode.COMBINATION_LINE_ITEMS_SIZE_EXCEEDED);
    }
}
