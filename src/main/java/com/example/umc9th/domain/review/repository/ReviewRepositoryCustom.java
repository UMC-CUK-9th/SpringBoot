package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryCustom {
    Page<Review> findMyReviews(Long userId,
                               Long storeId,
                               String storeName,
                               String ratingBand, // "ALL|FIVE|FOUR|THREE|TWO|ONE"
                               Pageable pageable);
}
