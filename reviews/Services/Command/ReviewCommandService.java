package com.example.demo.domain.reviews.Services.Command;

import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.reviews.repository.ReviewsRepository;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandService {
    private final ReviewsRepository reviewsRepository;

    @Transactional
    public Reviews createReview(Users user, Stores store, String content, Float rating) {
        // 객체 생성
        Reviews newReview = Reviews.builder()
                .users(user)
                .stores(store)
                .content(content)
                .rating(rating)
                .build();

        return reviewsRepository.save(newReview);
    }
}