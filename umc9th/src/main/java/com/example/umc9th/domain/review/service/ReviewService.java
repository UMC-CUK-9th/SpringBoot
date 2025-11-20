package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewRequest;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.ReviewErrorCode;
import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final QReview review = QReview.review;

    public List<ReviewResponse> searchMyReviews(Long userId, String type, String query) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(review.user.id.eq(userId));

        if (type.equals("store")) {
            builder.and(review.store.storeName.eq(query));

        } else if (type.equals("star")) {
            int starRange = Integer.parseInt(query);
            builder.and(starBetween(starRange));

        } else if (type.equals("both")) {
            String[] parts = query.split("&");
            String storeName = parts[0];
            int starRange = Integer.parseInt(parts[1]);

            builder.and(review.store.storeName.eq(storeName));
            builder.and(starBetween(starRange));
        }

        List<Review> results = reviewRepository.searchReview(builder);

        return results.stream()
                .map(r -> ReviewResponse.builder()
                        .id(r.getId())
                        .content(r.getReviewContent())
                        .favorite(r.getFavorite())
                        .storeName(r.getStore().getStoreName())
                        .build())
                .collect(Collectors.toList());
    }

    private BooleanBuilder starBetween(int starRange) {
        BooleanBuilder builder = new BooleanBuilder();

        if (starRange == 5) {
            builder.and(review.favorite.goe(5));
        } else {
            builder.and(review.favorite.between(starRange, starRange + 0.9));
        }
        return builder;
    }

    @Transactional
    public ReviewResponse createReview(Long userId, ReviewRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.USER_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.STORE_NOT_FOUND));

        Review review = Review.builder()
                .user(user)
                .store(store)
                .reviewContent(request.getContent())
                .favorite(request.getFavorite())
                .build();

        Review saved = reviewRepository.save(review);

        return ReviewResponse.builder()
                .id(saved.getId())
                .content(saved.getReviewContent())
                .favorite(saved.getFavorite())
                .storeName(saved.getStore().getStoreName())
                .build();
    }


}
