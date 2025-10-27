package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    // 5주차 미션 - 1. 리뷰 작성하는 쿼리
    Review save(Review review);
}
