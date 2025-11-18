package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.member.enums.FoodType;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "food")
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "foodName", length = 50, nullable = false)
    private String foodName;

    @Enumerated(EnumType.STRING)
    @Column(name = "foodType", nullable = false)
    private FoodType foodType;
}

