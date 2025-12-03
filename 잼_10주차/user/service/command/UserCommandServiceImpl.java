package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.entity.Food;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.UserFood;
import com.example.umc9th.domain.user.enums.Role;
import com.example.umc9th.domain.user.exception.FoodException;
import com.example.umc9th.domain.user.exception.code.FoodErrorCode;
import com.example.umc9th.domain.user.repository.FoodRepository;
import com.example.umc9th.domain.user.repository.UserFoodRepository;
import com.example.umc9th.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final FoodRepository foodRepository;
    private final UserFoodRepository userFoodRepository;
    // Password Encoder
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserResDto.CreateUser signupWithCreateUser(UserReqDto.CreateUser dto) {

        // 솔트된 비밀번호 생성
        String salt = passwordEncoder.encode(dto.password());

        // 사용자 생성: 유저 / 관리자는 따로 API 만들어서 관리
        User user = UserConverter.toEntity(dto, salt, Role.ROLE_USER);

        // 저장
        User saved = userRepository.save(user);

        // DTO 변환
        return UserConverter.toCreateUserDTO(saved);
    }

    @Override
    @Transactional
    public UserResDto.JoinDTO signup(UserReqDto.CreateUser dto){
        // 솔트된 비밀번호 생성
        String salt = passwordEncoder.encode(dto.password());

        // 사용자 생성: 유저 / 관리자는 따로 API 만들어서 관리
        User user = UserConverter.toEntity(dto, salt, Role.ROLE_USER);
        userRepository.save(user);

//        if (dto.getPreferCategory() != null && dto.getPreferCategory().size() > 0){
//            List<UserFood> list = new ArrayList<>();
//
//            for (Long id : dto.getPreferCategory()){
//
//                Food food = foodRepository.findById(id)
//                        .orElseThrow(() -> new FoodException(FoodErrorCode.NOT_FOUND));
//
//                UserFood uf = UserFood.builder()
//                        .user(user)
//                        .food(food)
//                        .build();
//
//                list.add(uf);
//            }
//
//            userFoodRepository.saveAll(list);
//        }

        return UserConverter.toJoinDTO(user);
    }
}