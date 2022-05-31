package com.example.nutrient.domain;

import static lombok.AccessLevel.PROTECTED;

import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

@Getter
@Embeddable
public class SupplementTitle {
    private static final String NAME_CANNOT_BE_EMPTY = "품목명은 비어있으면 안됩니다.";

    private final String name;

    protected SupplementTitle() {
        this.name = null;
    }
    public SupplementTitle(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (Strings.isEmpty(name)) {
            throw new IllegalArgumentException(NAME_CANNOT_BE_EMPTY);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SupplementTitle that = (SupplementTitle) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
