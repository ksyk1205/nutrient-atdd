package com.example.nutrient.domain.exception;

import static com.example.nutrient.domain.exception.SupplementErrorCode.OK;

public class SupplementException extends RuntimeException{
    private SupplementErrorCode errorCode = OK;

    public SupplementException(SupplementErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String errorMessage(){
        return errorCode.getMessage();
    }
}
