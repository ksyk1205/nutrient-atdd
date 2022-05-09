package com.example.nutrient.application.customvalidation;

import java.util.UUID;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

public class UUIDValidator implements ConstraintValidator<UUIDValid, UUID> {
    private static final int UUID_SIZE = 36;

    @Override
    public void initialize(UUIDValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext context) {
        if(Strings.isEmpty(value.toString())){
            return false;
        }else if(isUUID(value.toString())){
            return true;
        }
        return true;
    }

    private boolean isUUID(String uuid) {
        return uuid.matches("/^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$/i");
    }
}
