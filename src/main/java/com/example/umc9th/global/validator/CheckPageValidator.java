package com.example.umc9th.global.validator;

import com.example.umc9th.global.annotation.CheckPage;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

// 9주차 미션 - 페이지 번호 검증 Validator
@Component
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        // page가 null이거나 1보다 작으면 유효하지 않음
        boolean isValid = page != null && page >= 1;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(GeneralErrorCode.INVALID_PAGE.getMessage())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
