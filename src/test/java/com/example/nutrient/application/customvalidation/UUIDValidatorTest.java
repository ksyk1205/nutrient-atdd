package com.example.nutrient.application.customvalidation;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.nutrient.application.customvalidation.UUIDValidator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UUIDValidatorTest {

    @Test
    @DisplayName("UUID 형식이 올바른지 테스트 한다.")
    public void validateTest(){
        UUID uuid = UUID.randomUUID();
        UUIDValidator validator = new UUIDValidator();

        assertThat(validator.isValid(uuid, null)).isTrue();
    }

}