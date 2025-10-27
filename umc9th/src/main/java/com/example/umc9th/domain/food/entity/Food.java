package com.example.umc9th.domain.food.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "food")

public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "food_name",length = 15, nullable = false)
    private String foodName;

    @Column(name = "foodContent", length = 15)
    private String foodContent;

}
