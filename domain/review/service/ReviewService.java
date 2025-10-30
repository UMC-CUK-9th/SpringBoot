package com.example.umc9th.domain.review.service;
import com.example.umc9th.domain.review.*;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.user.*;
import com.example.umc9th.domain.store.*;
import com.example.umc9th.domain.review.repository.*;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.*;
import com.example.umc9th.domain.store.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Review writeReview(Long storeId, Long userId, int star, String detail) {
        User user = userRepository.findById(userId).orElseThrow();
        Store store = storeRepository.findById(storeId).orElseThrow();

        Review review = new Review();
        review.setUser(user);
        review.setStore(store);
        review.setStar(star);
        review.setDetail(detail);

        return reviewRepository.save(review);

        @Transactional(readOnly = true)
        public List<Review> getReviewsByStore(Long storeId) {
            return reviewRepository.findReviewsByStoreId(storeId);
        }

        @Transactional(readOnly = true)
        public Double getAverageStar(Long storeId) {
            return reviewRepository.findAverageStarByStoreId(storeId);
        }
}
