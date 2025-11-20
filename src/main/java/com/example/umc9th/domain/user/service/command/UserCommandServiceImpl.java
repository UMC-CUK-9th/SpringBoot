package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;
import com.example.umc9th.domain.user.entity.Food;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.UserFood;
import com.example.umc9th.domain.user.exception.food.FoodException;
import com.example.umc9th.domain.user.exception.food.FoodErrorCode;
import com.example.umc9th.domain.user.repository.FoodRepository;
import com.example.umc9th.domain.user.repository.UserFoodRepository;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;
    private final UserFoodRepository userFoodRepository;
    private final FoodRepository foodRepository;

    // 회원가입
    @Override
    public UserResDTO.JoinDTO signup(
            UserReqDTO.JoinDTO dto
    ){
        // 사용자 생성
        User user = UserConverter.toUser(dto);
        // DB 적용
        userRepository.save(user);
        
        // 선호 음식 존재 여부 확인
        if (dto.getPreferCategory().size() > 1){
            List<UserFood> userFoodList = new ArrayList<>();

            // 선호 음식 ID별 조회
            for (Long id : dto.getPreferCategory()){

                // 음식 존재 여부 검증
                Food food = foodRepository.findById(id)
                        .orElseThrow(() -> new FoodException(FoodErrorCode.FOOD_NOT_FOUND));

                // UserFood 엔티티 생성 (컨버터 사용해야 함)
                UserFood userFood = UserFood.builder()
                        .user(user)
                        .food(food)
                        .build();

                // 사용자 - 음식 (선호 음식) 추가
                userFoodList.add(userFood);
            }

            // 모든 선호 음식 추가: DB 적용
            userFoodRepository.saveAll(userFoodList);
        }


        // 응답 DTO 생성
        return UserConverter.toJoinDTO(user);
    }
}
