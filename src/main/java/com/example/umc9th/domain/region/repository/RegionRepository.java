package com.example.umc9th.domain.region.repository;

import com.example.umc9th.domain.region.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RegionRepository extends JpaRepository<Region, Long> {

    boolean existsByRegionName(String regionName);

    Optional<Region> findByRegionName(String regionName);
}