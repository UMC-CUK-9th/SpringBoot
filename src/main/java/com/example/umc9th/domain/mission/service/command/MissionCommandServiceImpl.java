package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc9th.domain.restaurant.repository.RestaurantRepository;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 8주차 미션 - 3. 가게에 미션 추가하기 API
@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public MissionResDTO.CreateDTO createMission(Long restId, MissionReqDTO.CreateDTO dto) {

        // 1) 미션을 등록할 가게 조회
        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new GeneralException(RestaurantErrorCode.REST_NOT_FOUND));

        // 2) 미션 엔티티 생성
        Mission mission = MissionConverter.toEntity(restaurant, dto);

        // 3) DB 저장
        Mission saved = missionRepository.save(mission);

        // 4) 응답 DTO 반환
        return MissionConverter.toCreateDTO(saved);
    }
}
