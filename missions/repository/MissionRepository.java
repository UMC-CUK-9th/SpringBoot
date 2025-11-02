package com.example.demo.domain.missions.repository;

import com.example.demo.domain.missions.entity.Missions;
import com.example.demo.domain.missions.entity.mapping.UserMissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Missions, Long> {
    // 지역별 미션 완료 개수 조회
    @Query("SELECT COUNT(um) " +
            "FROM UserMissions um " +
            "JOIN um.missions m " +
            "JOIN m.regions r " +
            "WHERE um.users.user_id = :userId " +
            "AND um.status = TRUE " +
            "AND r.regionId = :regionId")
    Long countCompletedMissionsInRegion(
            @Param("userId") Long userId,
            @Param("regionId") Long regionId
    );
}