package com.example.nutrient.domain.exception;

import static com.example.nutrient.domain.exception.SupplementErrorCode.OK;

public class SupplementException extends RuntimeException{

    public SupplementException(SupplementErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
