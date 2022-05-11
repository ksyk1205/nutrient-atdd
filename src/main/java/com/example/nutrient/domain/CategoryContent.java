package com.example.nutrient.domain;

import com.example.nutrient.domain.exception.CategoryErrorCode;
import com.example.nutrient.domain.exception.CategoryException;
import lombok.Getter;

import javax.persistence.Embeddable;

import static com.example.nutrient.domain.exception.CategoryErrorCode.CATEGORY_DEPTH_MUST_NOT_UNDER_LOWEST_DEPTH;

@Embeddable
@Getter
public class CategoryContent {
    private final static int LOWEST_DEPTH  = 0;
    private final int depth;

    public CategoryContent(int depth) {
        validate(depth);
        this.depth = depth;
    }

    protected CategoryContent() {
        this.depth = 0;
    }

    private void validate(int depth){
        if(depth < LOWEST_DEPTH){
            throw new CategoryException(CATEGORY_DEPTH_MUST_NOT_UNDER_LOWEST_DEPTH);
        }
    }
}
