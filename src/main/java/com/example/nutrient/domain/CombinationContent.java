package com.example.nutrient.domain;

import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.util.Objects;

@Embeddable
public class CombinationContent {
    private static final String COMBINATION_CONTENT_MUST_NOT_BE_EMPTY = "조합 내용은 비어있지 않아야 합니다.";

    @Lob
    private final String content;

    protected CombinationContent() {
        this.content = null;
    }

    public CombinationContent(String content) {
        validation(content);
        this.content = content;
    }

    private void validation(String content) {
        if (Strings.isEmpty(content)) {
            throw new IllegalArgumentException(COMBINATION_CONTENT_MUST_NOT_BE_EMPTY);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CombinationContent that = (CombinationContent) o;
        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
