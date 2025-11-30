package com.example.umc9th.domain.region.entity;

import com.example.umc9th.domain.restaurant.entity.Restaurant;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "regionName", length = 20, nullable = false)
    private String regionName;

    @OneToMany(mappedBy = "region")
    private List<Restaurant> restaurants = new ArrayList<>();
}