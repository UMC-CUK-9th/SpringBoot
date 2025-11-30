package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.entity.Food;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.UserFood;
import com.example.umc9th.domain.user.exception.FoodException;
import com.example.umc9th.domain.user.exception.code.FoodErrorCode;
import com.example.umc9th.domain.user.repository.FoodRepository;
import com.example.umc9th.domain.user.repository.UserFoodRepository;
import com.example.umc9th.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserResDto.CreateUser createUser(
            UserReqDto.CreateUser request
    ) {
        // 사용자 생성
        // request를 Entitiy로 변환
        User user = UserConverter.toEntitiy(request);
//

//        Entitiy를 ResponseDto로 변환
        return UserConverter.toCreateUserRes(user);

//        // 선호 음식 존재 여부 확인 (stream())
//        if (dto.preferCategory().size() > 1) {
//            List<UserFood> memberFood = dto.preferCategory().stream()
//                    .map(id -> UserFood.builder()
//                            .user(user)
//                            .user(foodRepository.findById(id)
//                                    .orElseThrow(() -> new FoodException(FoodErrorCode.FOOD_NOT_FOUND)))
//                            .build()
//                    )
//                    .collect(Collectors.toList());
//
//
//            userFoodRepository.saveAll(userFood);
        }
    }
//    public Long registerUser(UserCreateRequest request) {
//        User user = User.create(
//                request.getEmail(),
//                request.getPassword(),
//                request.getName()
//        );
//        userRepository.save(user);
//        return user.getId();
//    }

//
//    private final UserRepository userRepository;
//    private final UserFoodRepository userFoodRepository;
//    private final FoodRepository foodRepository;
//
//    // 회원가입
//    @Override
//    @Transactional
//    public UserResDto.JoinDTO signup(
//            UserReqDto.JoinDTO dto
//    ){
//        // 사용자 생성
//        User user = UserConverter.toUser(dto);
//        // DB 적용
//        userRepository.save(user);
//
//        // 선호 음식 존재 여부 확인
//        if (dto.preferCategory().size() > 1){
//            List<UserFood> userFoodList = new ArrayList<>();
//
//            // 선호 음식 ID별 조회
//            for (Long id : dto.preferCategory()){
//
//                // 음식 존재 여부 검증
//                Food food = foodRepository.findById(id)
//                        .orElseThrow(() -> new FoodException(FoodErrorCode.NOT_FOUND));
//
//                // MemberFood 엔티티 생성 (컨버터 사용해야 함)
//                UserFood memberFood = UserFood.builder()
//                        .user(user)
//                        .food(food)
//                        .build();
//
//                // 사용자 - 음식 (선호 음식) 추가
//                userFoodList.add(memberFood);
//            }
//
//            // 모든 선호 음식 추가: DB 적용
//            userFoodRepository.saveAll(userFoodList);
//        }
//
//
//        // 응답 DTO 생성
//        return UserConverter.toJoinDTO(user);
//    }