package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.region.entity.Region;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.global.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "mission")

public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mission_name", nullable = false)
    private String missionName;

    @Column(name = "mission_content", nullable = false)
    private String missionContent;

    @Column(name = "mission)_status", nullable = false)
    private MissionStatus missionStatus;

    @Column(name = "mission_point", nullable = false)
    private Integer missionPoint;

    @Column(name = "mission_end_date", nullable = false)
    private LocalDateTime missionEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id",nullable = false)
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

}
