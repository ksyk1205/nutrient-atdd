package com.example.nutrient.application.customvalidation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UUIDValidator.class)
@Target({ElementType.FIELD})
@Retention(RUNTIME)
public @interface UUIDValid {
    String message() default "UUID 형식이 올바르지 않습니다.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
