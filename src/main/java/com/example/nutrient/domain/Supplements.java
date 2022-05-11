package com.example.nutrient.domain;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Supplements {
    private final String SUPPLEMENTS_MUST_NOT_BE_EMPTY = "영양제 목록은 비어있지 않아야 합니다.";
    private final List<Supplement> supplements;

    public Supplements(List<Supplement> supplements) {
        validate(supplements);
        this.supplements = supplements;
    }

    private void validate(List<Supplement> supplements) {
        if (Objects.isNull(supplements) || supplements.isEmpty()) {
            throw new IllegalArgumentException(SUPPLEMENTS_MUST_NOT_BE_EMPTY);
        }
    }

    public boolean isDuplicated() {
        return supplements.size() != supplements.stream().distinct().count();
    }
}
