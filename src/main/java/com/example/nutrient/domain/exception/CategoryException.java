package com.example.nutrient.domain.exception;

public class CategoryException extends RuntimeException {

    public CategoryException(CategoryErrorCode categoryErrorCode){
        super(categoryErrorCode.getMessage());
    }
}
