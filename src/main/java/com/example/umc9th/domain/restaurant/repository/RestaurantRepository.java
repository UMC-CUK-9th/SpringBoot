package com.example.umc9th.domain.restaurant.repository;

import com.example.umc9th.domain.region.entity.Region;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    // 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
    boolean existsByRegionAndRestName(Region region, String restName);

    // 9주차 실습 - 가게의 리뷰 목록 조회하기 API
    // Optional<Restaurant> findByRestName(String restName);
}