package com.example.demo.global.Validator;

import com.example.demo.domain.missions.exception.code.MissionsErrorCode;
import com.example.demo.domain.missions.repository.MissionRepository;
import com.example.demo.global.annotation.ExistMissions;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMissions, List<Long>> {
    private final MissionRepository missionRepository;

    @Override public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> missionRepository.existsById(value));
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(MissionsErrorCode.MISSIONS_NOT_FOUND.getMessage()).addConstraintViolation();
        }
        return isValid;
    }
}