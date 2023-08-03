package com.danilermolenko.spring.mvc_rest_hibernate.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Digits;

public class NotDigitsValidator implements ConstraintValidator<NotDigits, String> {
    @Override
    public void initialize(NotDigits constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean f = true;
        char[] array = s.toCharArray();
        for(char el: array){
            if(Character.isDigit(el)){
                f = false;
                break;
            }
        }
        return f;
    }
}
