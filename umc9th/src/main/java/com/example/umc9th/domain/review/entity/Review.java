package com.example.umc9th.domain.review.entity;

import com.example.umc9th.domain.reviewImg.entity.ReviewImg;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "review")


public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "favorite",nullable = false)
    private Integer favorite;

    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id",nullable = false)
    private Store store;

    @OneToMany(mappedBy = "review",cascade = CascadeType.ALL)
    private List<ReviewImg> reviews = new ArrayList<>();

}
