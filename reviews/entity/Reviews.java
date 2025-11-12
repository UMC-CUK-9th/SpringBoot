package com.example.demo.domain.reviews.entity;

import com.example.demo.domain.reviews.entity.mapping.ReviewImages;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.users.entity.Users;
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
@Table(name = "reviews")

public class Reviews extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Stores stores;

    @Column(name = "rating", nullable = false)
    private Float rating;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "reply")
    private String reply;

    @OneToMany(mappedBy = "reviews", cascade = CascadeType.ALL)
    @Builder.Default
    private List<ReviewImages> reviewsImages = new ArrayList<>();
}
