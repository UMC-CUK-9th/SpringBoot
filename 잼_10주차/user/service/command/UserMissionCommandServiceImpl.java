package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.converter.UserMissionConverter;
import com.example.umc9th.domain.user.dto.Req.UserMissionReqDto;
import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserMissionResDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.entity.Food;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.UserFood;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import com.example.umc9th.domain.user.enums.UserStatus;
import com.example.umc9th.domain.user.exception.FoodException;
import com.example.umc9th.domain.user.exception.code.FoodErrorCode;
import com.example.umc9th.domain.user.exception.code.UserErrorCode;
import com.example.umc9th.domain.user.repository.FoodRepository;
import com.example.umc9th.domain.user.repository.UserFoodRepository;
import com.example.umc9th.domain.user.repository.UserMissionRepository;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserRepository userRepository;
    private final UserFoodRepository userFoodRepository;
    private final UserMissionRepository userMissionRepository;
    private final FoodRepository foodRepository;
    private final MissionRepository missionRepository;

    // paging 처리
    public Page<UserMissionResDto.CreateDTO> getMyMissions(Long memberId, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<UserMission> result =
                userMissionRepository.findByUserIdAndStatus(memberId, UserStatus.IN_PROGRESS, pageable);
        return result.map(UserMissionResDto::from);
    }

    @Transactional
    public void mission(
            Long userId, Long missionId, Long storeId
    ) {
//       사용자 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(UserErrorCode.USER_NOT_FOUND));

        // 2) 미션 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(MissionErrorCode.MISSION_NOT_FOUND));

        // 3) 매칭 검증 - 특정 미션이 해당 가게의 미션인지 검증
        if (!mission.getStore().getId().equals(storeId)) {
            throw new GeneralException(MissionErrorCode.MISSION_NOT_IN_STORE);
        }

        // 3) MemberMission 엔티티 생성
        UserMission userMission = UserMissionConverter.toEntity(user, mission);

        userMissionRepository.save(userMission);
        // 5) 응답 DTO 반환

    }
    public void updateMission(Long UserMissionId,UserStatus userStatus) {
        UserMission userMission = userMissionRepository.findByIdAndStatus(UserMissionId, userStatus)
                .orElseThrow(() -> new GeneralException(MissionErrorCode.MISSION_NOT_FOUND));

        userMission.setStatus(UserStatus.IN_PROGRESS);

        userMissionRepository.save(userMission);
    }

    public List<UserInfoDto> getUserBasicInfo(Long userId){
        return userRepository.findUserInfoById(userId);
    }


}
//    public void updateMission(Long userId, Long missionId){
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new GeneralException(UserErrorCode.USER_NOT_FOUND));
//
//        Mission mission = missionRepository.findById(missionId)
//                .orElseThrow(() -> new GeneralException(MissionErrorCode.MISSION_NOT_FOUND));
//
//        UserMission userMission = UserMissionConverter.UpdateEntity(user,mission);
//

//        userMissionRepository.save(userMission);
//    }

