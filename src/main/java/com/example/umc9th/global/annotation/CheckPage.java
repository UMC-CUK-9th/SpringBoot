package com.example.umc9th.global.annotation;

import com.example.umc9th.global.validator.CheckPageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

// 9주차 미션 - 페이지 번호 검증 커스텀 어노테이션
@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지 번호는 1 이상이어야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
