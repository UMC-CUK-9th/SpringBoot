package com.example.demo.domain.missions.entity.mapping;

import com.example.demo.domain.missions.entity.Missions;
import com.example.demo.domain.members.entity.Members;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "memberMissions")

public class MemberMissions extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberMiId", nullable = false)
    private Long memberMiId;

    @Column(name = "status", nullable = false)
    private Boolean status; // 0 : progress 1 : complete

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", nullable = false)
    private Members members;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "missionId", nullable = false)
    private Missions missions;
}
