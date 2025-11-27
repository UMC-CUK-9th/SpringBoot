package com.example.demo.global.Validator;

import com.example.demo.domain.members.exception.code.PreferencesErrorCode;
import com.example.demo.domain.members.repository.PreferencesRepository;
import com.example.demo.global.annotation.ExistPreferences;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PreferencesExistValidator implements ConstraintValidator<ExistPreferences, List<Long>> {
    private final PreferencesRepository preferencesRepository;

    @Override public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> preferencesRepository.existsById(value));
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(PreferencesErrorCode.NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;
    }
}