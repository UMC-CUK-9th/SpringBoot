package com.example.umc9th.domain.restaurant.entity;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "Restaurant")
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "address", columnDefinition = "TEXT", nullable = false)
    private String address;

    @Column(name = "region", length = 20, nullable = false)
    private String region;

    @Column(name = "category", length = 20, nullable = false)
    private String category;

    @Column(name = "ownerNumber", nullable = false)
    private String ownerNumber;

    @OneToMany(mappedBy = "restaurant")
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();
}

