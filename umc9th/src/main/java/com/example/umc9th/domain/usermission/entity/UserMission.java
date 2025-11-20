package com.example.umc9th.domain.usermission.entity;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "user_mission")

public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id",nullable = false)
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_mission_status", nullable = false)
    private UserMissionStatus userMissionStatus;

    @Column(name = "user_mission_started_at", nullable = false)
    private LocalDateTime userMissionStartedAt;

    @Column(name = "user_mission_completed_at", nullable = true)
    private LocalDateTime userMissionCompletedAt;

    @Column(name = "certification_number", nullable = true)
    private String certificationNumber;
}
