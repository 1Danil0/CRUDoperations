package com.danilermolenko.spring.mvc_rest_hibernate.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotDigitsValidator.class)
public @interface NotDigits {

    public String message() default "should not contain digits";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
