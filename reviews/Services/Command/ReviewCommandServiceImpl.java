package com.example.demo.domain.reviews.Services.Command;

import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.reviews.repository.ReviewsRepository;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.users.entity.Users;
import com.example.demo.domain.reviews.exception.ReviewException;
import com.example.demo.domain.reviews.exception.code.ReviewErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewsRepository reviewsRepository;

    @Override
    @Transactional
    public Reviews createReview(Users user, Stores store, String content, Float rating) {
        if (user == null || store == null) {
            throw new ReviewException(ReviewErrorCode.REVIEW_EXCEPTION);
        }

        Reviews review = Reviews.builder()
                .users(user)
                .stores(store)
                .content(content)
                .rating(rating)
                .build();

        return reviewsRepository.save(review);
    }
}
