package com.example.umc9th.domain.usermission.repository;

import com.example.umc9th.domain.usermission.entity.UserMission;
import com.example.umc9th.domain.usermission.entity.UserMissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    List<UserMission> findByUserIdAndUserMissionStatus(Long userId, UserMissionStatus userMissionStatus);
}
