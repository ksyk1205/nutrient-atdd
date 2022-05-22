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

    public CategoryContent(Integer depth) {
        int basicDepth = 0;
        if(depth != null){
            basicDepth = depth;
        }
        validate(basicDepth);
        this.depth = basicDepth;
    }

    protected CategoryContent() {
        this.depth = 0;
    }

    private void validate(Integer depth){
        if(depth < LOWEST_DEPTH){
            throw new CategoryException(CATEGORY_DEPTH_MUST_NOT_UNDER_LOWEST_DEPTH);
        }
    }
}
