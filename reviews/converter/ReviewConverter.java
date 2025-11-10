package com.example.demo.domain.reviews.converter;

import com.example.demo.domain.reviews.dto.ReviewRequestDto;
import com.example.demo.domain.reviews.dto.ReviewsResponseDto;
import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.users.entity.Users;

public class ReviewConverter {
    public static Reviews toReview(
            ReviewRequestDto request,
            Users user,
            Stores store
    ) {
        return Reviews.builder()
                .users(user)
                .stores(store)
                .content(request.getContent())
                .rating(request.getRating())
                .build();
    }

    public static ReviewsResponseDto toReviewResponseDto(
            Reviews review
    ){
        return ReviewsResponseDto.builder()
                .id(review.getReviewId())
                .content(review.getContent())
                .rating(review.getRating())
                .storeName(review.getStores().getName())
                .build();
    }
}
