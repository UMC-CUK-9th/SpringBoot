package com.example.demo.domain.stores.entity;

import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.missions.entity.Missions;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "regions")

public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", nullable = false)
    private Long regionId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "regions", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Stores> storesList = new ArrayList<>();

    @OneToMany(mappedBy = "regions", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Missions> missionsList = new ArrayList<>();
}
