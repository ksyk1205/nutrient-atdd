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
        }else if(isUUIDSize(value.toString())){
            return true;
        }
        return true;
    }

    private boolean isUUIDSize(String uuid) {
        return uuid.length() == UUID_SIZE;
    }
}
