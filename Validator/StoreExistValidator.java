package com.example.demo.global.Validator;


import com.example.demo.domain.missions.exception.code.MissionsErrorCode;
import com.example.demo.domain.missions.repository.MissionRepository;
import com.example.demo.domain.reviews.exception.code.ReviewErrorCode;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.stores.repository.StoreRepository;
import com.example.demo.global.annotation.ExistMissions;
import com.example.demo.global.annotation.ExistStores;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStores, List<Long>> {
    private final StoreRepository storeRepository;

    @Override public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> storeRepository.existsById(value));
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ReviewErrorCode.STORE_EXCEPTION.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}