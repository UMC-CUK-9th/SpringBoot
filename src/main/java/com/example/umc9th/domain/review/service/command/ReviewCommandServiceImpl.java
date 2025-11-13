package com.example.umc9th.domain.review.service.command;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.review.exception.code.ReviewErrorCode;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    public ReviewResDTO.CreateReviewResultDTO createReview(ReviewReqDTO.CreateReviewDTO req) {
        // 유효성 검사
        if (req.getContent() == null || req.getContent().isEmpty()) {
            throw new ReviewException(ReviewErrorCode.REVIEW_CONTENT_EMPTY);
        }

        if (req.getStar() == null || req.getStar() < 0.5f || req.getStar() > 5.0f) {
            throw new ReviewException(ReviewErrorCode.INVALID_REVIEW_STAR);
        }

        // Store 존재 여부 확인
        Store store = storeRepository.findById(req.getStoreId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_STORE_NOT_FOUND));

        // User 존재 여부 확인
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_USER_NOT_FOUND));

        // Review Entity 생성 및 저장
        Review review = Review.builder()
                .content(req.getContent())
                .star(req.getStar())
                .store(store)
                .user(user)
                .build();

        Review savedReview = reviewRepository.save(review);

        return ReviewConverter.toCreateReviewResultDTO(savedReview);
    }

    @Override
    public void updateReview(Long reviewId, ReviewReqDTO.UpdateReviewDTO req) {
        // 리뷰 존재 여부 검증
        reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_NOT_FOUND));

        // 유효성 검사
        if (req.getContent() != null && req.getContent().isEmpty()) {
            throw new ReviewException(ReviewErrorCode.REVIEW_CONTENT_EMPTY);
        }

        if (req.getStar() != null && (req.getStar() < 0.5f || req.getStar() > 5.0f)) {
            throw new ReviewException(ReviewErrorCode.INVALID_REVIEW_STAR);
        }

        // Review Entity 업데이트 (필요에 따라 업데이트 메서드 추가)
    }

    @Override
    public void deleteReview(Long reviewId) {
        // 리뷰 존재 여부 검증
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_NOT_FOUND));

        // Review Entity 삭제
        reviewRepository.delete(review);
    }
}
