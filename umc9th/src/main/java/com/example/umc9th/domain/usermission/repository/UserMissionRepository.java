package com.example.umc9th.domain.usermission.repository;

import com.example.umc9th.domain.usermission.dto.UserMissionResponse;
import com.example.umc9th.domain.usermission.entity.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("""
        SELECT new com.example.umc9th.domain.usermission.dto.UserMissionResponse(
            s.storeName,
            m.missionContent,
            m.missionPoint,
            m.missionStatus
        )
        FROM UserMission um
        JOIN um.mission m
        JOIN m.store s
        WHERE um.user.id = :userId
          AND um.userMissionStatus = 'COMPLETE'
    """)
    List<UserMissionResponse> findUserMissionsByUserId(@Param("userId") Long userId);

    boolean existsByUserIdAndMissionId(Long userId, Long missionId);

}
