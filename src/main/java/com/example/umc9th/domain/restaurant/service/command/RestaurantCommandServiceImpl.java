package com.example.umc9th.domain.restaurant.service.command;

import com.example.umc9th.domain.restaurant.converter.RestaurantConverter;
import com.example.umc9th.domain.restaurant.dto.req.RestaurantReqDTO;
import com.example.umc9th.domain.restaurant.dto.res.RestaurantResDTO;
import com.example.umc9th.domain.region.entity.Region;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.domain.region.exception.RegionErrorCode;
import com.example.umc9th.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc9th.domain.region.repository.RegionRepository;
import com.example.umc9th.domain.restaurant.repository.RestaurantRepository;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public RestaurantResDTO.CreateRestDTO createInRegion(Long regionId, RestaurantReqDTO.CreateRestDTO dto) {

        // 1) regionId로 Region 엔티티 조회
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new GeneralException(RegionErrorCode.REGION_NOT_FOUND));

        // 2) 같은 지역 + 같은 이름 가게 중복 여부 체크
        if (restaurantRepository.existsByRegionAndRestName(region, dto.getRestName())) {
            throw new GeneralException(RestaurantErrorCode.REST_DUPLICATED);
        }

        // 3) 엔티티 생성 및 저장
        Restaurant saved = restaurantRepository.save(
                RestaurantConverter.toEntity(region, dto)
        );

        // 4) 응답 DTO 변환
        return RestaurantConverter.toCreateDTO(saved);
    }
}