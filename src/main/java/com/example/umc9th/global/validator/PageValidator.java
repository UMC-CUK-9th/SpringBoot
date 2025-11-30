package com.example.umc9th.global.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // null인 경우는 @RequestParam(defaultValue = "1")로 막을 거라 일단 true
        if (value == null) return true;
        return value >= 1;
    }
}