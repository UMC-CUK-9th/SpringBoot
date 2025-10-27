package com.example.demo.domain.stores.entity;

import com.example.demo.domain.missions.entity.Missions;
import com.example.demo.domain.stores.entity.mapping.StoreImages;
import com.example.demo.domain.stores.entity.Regions;
import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.stores.entity.mapping.Categories;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "stores")

public class Stores extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", nullable = false)
    private Long storeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Regions regions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id", nullable = false)
    private Categories categories;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false)
    private boolean isActive; // 0 : 영업 중 1: 영업 종료

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "number", nullable = false)
    private String number; // 가게 전화번호

    @Column(name = "rate_avg", nullable = false)
    private Float rateAvg;

    @Column(name = "hour", nullable = false)
    private String hour; // 가게 영업시간

    @OneToMany(mappedBy = "stores", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Reviews> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "stores", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<StoreImages> storeImagesList = new ArrayList<>();

    @OneToMany(mappedBy = "stores", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Missions> missionsList = new ArrayList<>();
}
