package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    //5주차 진행중,진행완료한 미션 JPQL 쿼리
    //status 값에 따라 진행 중, 진행 완료, 전체 달라짐
    @Query(
            value = """
        SELECT um
        FROM UserMission um
        JOIN FETCH um.mission m
        JOIN FETCH m.store s
        WHERE um.user.id = :userId
          AND ( :status IS NULL OR um.status = :status )
        ORDER BY um.createdAt DESC
        """,
            countQuery = """
        SELECT COUNT(um)
        FROM UserMission um
        JOIN um.mission m
        WHERE um.user.id = :userId
          AND ( :status IS NULL OR um.status = :status )
        """
    )
    Page<UserMission> findMyMissionsFetchWithStore(
            @Param("userId") Long userId,
            @Param("status") Boolean status,  // null=전체, true=완료, false=진행중 , 컬럼에서 isComplete 값
            Pageable pageable
    );

    // 8주차 과제: 미션 도전하기 API - 특정 유저가 특정 미션에 이미 도전 중인지 확인
    boolean existsByUserIdAndMissionId(Long userId, Long missionId);
}
