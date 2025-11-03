package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.enums.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    // 5주차 미션 - 3. 내가 진행중, 진행 완료한 미션 모아서 보는 쿼리
    // 5주차 피드백 반영 - 커서 기반 페이징 선택
    // 진행중(ONGOING) 미션 목록
    @Query("""
        SELECT ms
        FROM MemberMission ms
        JOIN FETCH ms.mission m
        JOIN FETCH m.restaurant r
        WHERE ms.member.id = :memberId
          AND ms.status = :status
          AND (:cursorTime IS NULL OR m.updatedAt < :cursorTime)
        ORDER BY m.updatedAt DESC
    """)
    List<MemberMission> findByMemberAndStatusOngoing(
            @Param("memberId") Long memberId,
            @Param("status") MissionStatus status,
            @Param("cursorTime") LocalDateTime cursorTime
    );

    // 완료(COMPLETED) 미션 목록
    @Query("""
        SELECT ms
        FROM MemberMission ms
        JOIN FETCH ms.mission m
        JOIN FETCH m.restaurant r
        WHERE ms.member.id = :memberId
          AND ms.status = :status
          AND (:cursorTime IS NULL OR m.updatedAt < :cursorTime)
        ORDER BY m.updatedAt DESC
    """)
    List<MemberMission> findByMemberAndStatusCompleted(
            @Param("memberId") Long memberId,
            @Param("status") MissionStatus status,
            @Param("cursorTime") LocalDateTime cursorTime
    );

    // 4. 홈 화면 쿼리-1
    @Query("""
        SELECT COUNT(mm)
        FROM MemberMission mm
        WHERE mm.member.id = :memberId
          AND mm.mission.restaurant.region = :region
          AND mm.status = :status
    """)
    Long countCompletedMissionsInRegion(
            @Param("memberId") Long memberId,
            @Param("region") String region,
            @Param("status") MissionStatus status
    );
}
