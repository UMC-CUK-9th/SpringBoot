package com.example.demo.domain.reviews.converter;

import com.example.demo.domain.reviews.dto.ReviewResDto;
import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.reviews.entity.mapping.ReviewImages;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResDto.ReviewInfo toReviewInfoDTO(Reviews review) {
        List<String> imageUrls = review.getReviewsImages()
                .stream()
                .map(ReviewImages::getImageUrl)
                .collect(Collectors.toList());

        return ReviewResDto.ReviewInfo.builder()
                .id(review.getReviewId())
                .storeName(review.getStores().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .imageUrls(imageUrls)
                .build();
    }

    // 리뷰 리스트 변환
    public static ReviewResDto.ReviewList toReviewListDTO(List<Reviews> reviews) {
        List<ReviewResDto.ReviewInfo> reviewInfos = reviews.stream()
                .map(ReviewConverter::toReviewInfoDTO)
                .collect(Collectors.toList());

        return ReviewResDto.ReviewList.builder()
                .reviews(reviewInfos)
                .build();
    }
}
