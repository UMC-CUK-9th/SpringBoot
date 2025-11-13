package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.MissionDto;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
        SELECT new com.example.umc9th.domain.mission.dto.MissionDto(
            m.id,
            m.deadline,
            m.conditional,
            m.point,
            m.createdAt
        )
        FROM Mission m
        LEFT JOIN UserMission um
            ON um.mission = m
            AND um.user.id = :userId
        JOIN m.store s
        JOIN s.location l
        WHERE l.name = :locationName
          AND (um.id IS NULL OR um.isComplete = FALSE)
        ORDER BY m.id DESC
    """)
    List<MissionDto> findAvailableMissionsByLocation(
            @Param("locationName") String locationName,
            @Param("userId") Long userId,
            Pageable pageable
    );
}