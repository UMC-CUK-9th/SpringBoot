package com.example.umc9th.domain.usermission.repository;

import com.example.umc9th.domain.usermission.entity.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("""
        SELECT m.missionPoint, m.missionStatus, m.missionContent, s.storeName
        FROM UserMission um
        JOIN um.mission m
        JOIN m.store s
        WHERE um.user.id = :userId
          AND um.userMissionStatus = 'COMPLETE'
        """)
    List<Object[]> findUserMissionsByUserId(@Param("userId") Long userId);
}
