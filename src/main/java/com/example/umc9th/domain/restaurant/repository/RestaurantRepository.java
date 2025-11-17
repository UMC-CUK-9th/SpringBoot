package com.example.umc9th.domain.restaurant.repository;

import com.example.umc9th.domain.region.entity.Region;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

// 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    boolean existsByRegionAndRestName(Region region, String restName);
}