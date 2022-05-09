package com.example.nutrient.domain;

import com.example.nutrient.domain.exception.CategoryErrorCode;
import com.example.nutrient.domain.exception.CategoryException;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;

import java.util.Objects;

import static com.example.nutrient.domain.exception.CategoryErrorCode.CATEGORY_NAME_MUST_NOT_BE_EMPTY;

@Embeddable
public class CategoryTitle {
    private final String name;


    protected CategoryTitle() {
        this.name = null;
    }

    public CategoryTitle(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name){
        if(Strings.isEmpty(name)){
            throw new CategoryException(CATEGORY_NAME_MUST_NOT_BE_EMPTY);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryTitle that = (CategoryTitle) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
