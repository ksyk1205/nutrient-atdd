package com.example.nutrient.domain.exception;

public enum ErrorCode {
    COMBINATION_LINE_ITEMS_SIZE_EXCEEDED(400, "Combination Line Items Size Exceeded"),
    COMBINATION_LINE_ITEM_DUPLICATE(400, " Combination Line Item is duplicated")
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
