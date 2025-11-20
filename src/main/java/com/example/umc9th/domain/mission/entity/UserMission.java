package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

// 8주차 과제: 미션 도전하기 API - User와 Mission 매핑 엔티티
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "user_mission")
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Builder.Default
    private MissionStatus status = MissionStatus.CHALLENGING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    // 8주차 과제: 미션 완료 처리 메서드
    public void completeChallenge() {
        this.status = MissionStatus.COMPLETED;
    }
}
