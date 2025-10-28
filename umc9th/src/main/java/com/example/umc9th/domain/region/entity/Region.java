package com.example.umc9th.domain.region.entity;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "region")

public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "region_name",nullable = false)
    private String regionName;

    @Column(name = "region_address", nullable = false)
    private String regionAddress;

    @OneToMany(mappedBy = "region")
    public List<Store> stores = new ArrayList<>();

    @OneToMany(mappedBy = "region")
    public List<Mission> missions = new ArrayList<>();

}
