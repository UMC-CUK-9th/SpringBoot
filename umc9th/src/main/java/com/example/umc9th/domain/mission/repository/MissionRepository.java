package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.MissionDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.usermission.entity.UserMissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
        SELECT new com.example.umc9th.domain.mission.dto.MissionDto(
            r.regionName,
            u.userPoint,
            (SELECT COUNT(um) 
             FROM UserMission um 
             WHERE um.user.id = :userId 
               AND um.userMissionStatus = :completedStatus 
               AND um.mission.region.id = r.id),
            m.id,
            s.storeName,
            s.category,
            m.missionContent,
            m.missionPoint,
            m.missionStatus,
            FUNCTION('DATEDIFF', m.missionEndDate, CURRENT_DATE)
        )
        FROM Mission m
        JOIN m.store s
        JOIN m.region r
        JOIN User u
        WHERE r.id = :regionId
          AND m.missionStatus IN ('START','ING')
          AND m.id < :lastMissionId
        ORDER BY m.id DESC
        """)
    List<MissionDto> findMissionsByRegion(
            @Param("userId") Long userId,
            @Param("regionId") Long regionId,
            @Param("lastMissionId") Long lastMissionId,
            @Param("completedStatus") UserMissionStatus completedStatus
    );
}
