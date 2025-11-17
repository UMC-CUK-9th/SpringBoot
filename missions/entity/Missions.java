package com.example.demo.domain.missions.entity;

import com.example.demo.domain.missions.entity.mapping.MemberMissions;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.stores.entity.Regions;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "missions")

public class Missions extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id", nullable = false)
    private Integer missionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Stores stores;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId", nullable = false)
    private Regions regions;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "reward", nullable = false)
    private Integer reward;

    @Column(name = "deadline", nullable = false)
    private LocalDateTime deadline;

    @OneToMany(mappedBy = "missions", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberMissions> memberMissions = new ArrayList<>();
}
