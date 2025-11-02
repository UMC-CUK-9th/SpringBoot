package com.example.demo.domain.reviews.service;

import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.reviews.entity.mapping.ReviewImages;
import com.example.demo.domain.reviews.repository.ReviewImagesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewImageService {
    private final ReviewImagesRepository reviewImagesRepository;

    @Transactional
    public ReviewImages createReviewImage(Reviews review, String imageUrl) {
        // 객체 생성
        ReviewImages newReviewImage = ReviewImages.builder()
                .reviews(review)
                .reviewUrl(imageUrl)
                .build();

        return reviewImagesRepository.save(newReviewImage);
    }
}