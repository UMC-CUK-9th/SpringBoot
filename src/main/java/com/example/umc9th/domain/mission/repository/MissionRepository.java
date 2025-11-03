package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    // 5주차 미션 - 4. 홈 화면 쿼리-2
    // 5주차 피드백 반영 - 커서 기반 페이징 선택
    @Query("""
        SELECT m
        FROM Mission m
        JOIN FETCH m.restaurant r
        WHERE r.region = :region
          AND m.deadline > CURRENT_TIMESTAMP
          AND (:cursorId IS NULL OR m.id < :cursorId)
        ORDER BY m.createdAt DESC
    """)
    List<Mission> findAvailableMissionsByRegion(
            @Param("region") String region,
            @Param("cursorId") Long cursorId
    );
}
