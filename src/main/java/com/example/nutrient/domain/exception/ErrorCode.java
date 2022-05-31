package com.example.nutrient.domain.exception;

public enum ErrorCode {
    COMBINATION_LINE_ITEMS_SIZE_EXCEEDED(400, "조합 품목 목록이 최대값을 초과하였습니다."),
    COMBINATION_LINE_ITEM_DUPLICATE(400, "조합 품목이 중복됩니다.")
    ;

    private final String message;
    private final int status;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
