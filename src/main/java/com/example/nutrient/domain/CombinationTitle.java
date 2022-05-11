package com.example.nutrient.domain;

import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CombinationTitle {
    private static final String COMBINATION_TITLE_MUST_NOT_BE_EMPTY = "조합 제목은 비어있지 않아야 합니다.";
    private final String title;

    protected CombinationTitle() {
        this.title = null;
    }

    public CombinationTitle(String title) {
        validate(title);
        this.title = title;
    }

    private void validate(String title) {
        if (Strings.isEmpty(title)) {
            throw new IllegalArgumentException(COMBINATION_TITLE_MUST_NOT_BE_EMPTY);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CombinationTitle that = (CombinationTitle) o;
        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
