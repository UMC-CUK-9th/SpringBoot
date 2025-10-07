package com.example.demo.domain.reviews.entity.mapping;

import com.example.demo.domain.reviews.entity.Reviews;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "review_images")

public class ReviewImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_image_id", nullable = false)
    private Long reviewImageId;

    @Column(name = "review_url", nullable = false)
    private String reviewUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Reviews reviews;
}