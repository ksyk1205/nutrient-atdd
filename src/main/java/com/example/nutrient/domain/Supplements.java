package com.example.nutrient.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Supplements {
    private final List<Supplement> supplements;

    public boolean isDuplicated() {
        return supplements.size() != supplements.stream().distinct().count();
    }
}
