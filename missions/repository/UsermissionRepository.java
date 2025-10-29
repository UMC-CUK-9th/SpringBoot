package com.example.demo.domain.missions.repository;

import com.example.demo.domain.missions.entity.mapping.UserMissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsermissionRepository extends JpaRepository<UserMissions, Long> {
    // 사용자 미션 조회 - 진행 상태 여부 상관 x
    @Query("SELECT um FROM UserMissions um " +
            "JOIN FETCH um.missions m " +
            "JOIN FETCH m.stores s " +
            "WHERE um.users.user_id = :userId ORDER BY m.deadline ASC, um.createdAt DESC")
    Page<UserMissions> findAllMissionsListByUserId(@Param("userId") Long userId, Pageable pageable);

    // 진행 중
    @Query("SELECT um FROM UserMissions um " +
            "JOIN FETCH um.missions m " +
            "JOIN FETCH m.stores s " +
            "WHERE um.users.user_id = :userId AND um.status = FALSE " +
            "ORDER BY m.deadline ASC, um.createdAt DESC")
    Page<UserMissions> findProgressMissionsListByUserId(@Param("userId") Long userId, Pageable pageable);

    // 진행 완료
    @Query("SELECT um FROM UserMissions um " +
            "JOIN FETCH um.missions m " +
            "JOIN FETCH m.stores s " +
            "WHERE um.users.user_id = :userId AND um.status = TRUE " +
            "ORDER BY m.deadline ASC, um.createdAt DESC")
    Page<UserMissions> findCompleteMissionsListByUserId(@Param("userId") Long userId, Pageable pageable);
}