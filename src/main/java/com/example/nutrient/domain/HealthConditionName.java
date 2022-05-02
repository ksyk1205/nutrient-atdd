package com.example.nutrient.domain;

import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class HealthConditionName {
    private static final String HEALTH_CONDITION_NAME_MUST_NOT_BE_NULL = "건강 상태 이름은 비어있지 않아야 합니다.";
    private final String name;

    protected HealthConditionName() {
        this.name = null;
    }

    protected HealthConditionName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (Strings.isEmpty(name)) {
            throw new IllegalArgumentException(HEALTH_CONDITION_NAME_MUST_NOT_BE_NULL);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthConditionName that = (HealthConditionName) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
