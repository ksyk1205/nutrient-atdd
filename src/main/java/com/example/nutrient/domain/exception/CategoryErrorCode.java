package com.example.nutrient.domain.exception;

import lombok.Getter;

@Getter
public enum CategoryErrorCode {
     CATEGORY_NAME_MUST_NOT_BE_EMPTY(400, "카테고리 명은 비어있지 않아야 합니다.");

    private int status;
    private String message;

    CategoryErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
