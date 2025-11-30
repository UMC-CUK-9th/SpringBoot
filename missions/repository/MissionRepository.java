package com.example.demo.domain.missions.repository;

import com.example.demo.domain.missions.entity.Missions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Missions, Long> {
    // 지역별 미션 완료 개수 조회
    @Query("SELECT COUNT(um) " +
            "FROM MemberMissions um " +
            "JOIN um.missions m " +
            "JOIN m.regions r " +
            "WHERE um.members.memberId = :memberId " +
            "AND um.status = TRUE " +
            "AND r.regionId = :regionId")
    Long countCompletedMissionsInRegion(
            @Param("memberId") Long memberId,
            @Param("regionId") Long regionId
    );
}
