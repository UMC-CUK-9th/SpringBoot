package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc9th.domain.restaurant.repository.RestaurantRepository;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    // 9주차 미션 - 2. 특정 가게에 미션 목록 조회하기 API
    @Override
    public MissionResDTO.MissionPreviewListDTO getRestMissions(Long restId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new GeneralException(RestaurantErrorCode.REST_NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        return MissionConverter.toMissionPreviewListDTO(
                missionRepository.findAllByRestaurant(restaurant, pageRequest)
        );
    }
}