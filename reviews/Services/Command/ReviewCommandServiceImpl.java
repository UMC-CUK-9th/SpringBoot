package com.example.demo.domain.reviews.Services.Command;

import com.example.demo.domain.members.entity.Members;
import com.example.demo.domain.members.repository.MemberRepository;
import com.example.demo.domain.reviews.converter.ReviewConverter;
import com.example.demo.domain.reviews.dto.ReviewReqDto;
import com.example.demo.domain.reviews.dto.ReviewResDto;
import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.reviews.exception.ReviewException;
import com.example.demo.domain.reviews.exception.code.ReviewErrorCode;
import com.example.demo.domain.reviews.repository.ReviewsRepository;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.stores.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewsRepository reviewsRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public ReviewResDto.ReviewInfo createReview(ReviewReqDto request) {

        Members member = memberRepository.findById(request.getUserId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.MEMBER_EXCEPTION));

        Stores store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.STORE_EXCEPTION));

        Reviews newReview = ReviewConverter.toReview(
                request,
                member,
                store
        );

        Reviews createdReview = reviewsRepository.save(newReview);

        return ReviewConverter.toReviewInfoDTO(createdReview);
    }
}
