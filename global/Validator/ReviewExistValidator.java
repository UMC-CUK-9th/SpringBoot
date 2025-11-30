package com.example.demo.global.Validator;

import com.example.demo.domain.reviews.exception.code.ReviewErrorCode;
import com.example.demo.domain.reviews.repository.ReviewsRepository;
import com.example.demo.global.annotation.ExistReviews;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewExistValidator implements ConstraintValidator<ExistReviews, List<Long>> {
    private final ReviewsRepository reviewsRepository;

    @Override public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> reviewsRepository.existsById(value));
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ReviewErrorCode.REVIEW_EXCEPTION.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}