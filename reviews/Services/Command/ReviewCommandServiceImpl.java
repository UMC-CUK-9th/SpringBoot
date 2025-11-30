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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewsRepository reviewsRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    // 리뷰 작성
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

    // 내가 작성한 리뷰 조회 (페이징)
    @Override
    public ReviewResDto.ReviewList findReviewsByUser(Long memberId, int page, int size) {
        Pageable pageable = PageRequest.of(
                page - 1,
                size,
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        Page<Reviews> found = reviewsRepository.findByMembers_MemberId(memberId, pageable);

        return ReviewConverter.toReviewListDTO(found.getContent());
    }

    // 특정 가게 리뷰 조회 (페이징)
    @Override
    public ReviewResDto.ReviewList findReviewsByStore(Long storeId, int page, int size) {
        Pageable pageable = PageRequest.of(
                page - 1,
                size,
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        Page<Reviews> found = reviewsRepository.findByMembers_MemberId(storeId, pageable);

        return ReviewConverter.toReviewListDTO(found.getContent());
    }
}
