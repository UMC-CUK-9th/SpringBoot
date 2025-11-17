package com.example.umc9th.domain.review.service.Command;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc9th.domain.restaurant.repository.RestaurantRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.Req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.Res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 8주차 미션 - 2. 가게에 리뷰 추가하기 API
@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public ReviewResDTO.CreateReviewDTO createReview(Long restId, ReviewReqDTO.CreateReviewDTO dto) {
        // 1) 레스토랑 조회
        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new GeneralException(RestaurantErrorCode.REST_NOT_FOUND));

        // 2) 로그인 미구현 → 테스트용 하드코딩 멤버
        Long memberId = 1L;
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(MemberErrorCode.MEMBER_NOT_FOUND));

        // 3) 엔티티 생성 & 저장
        Review saved = reviewRepository.save(ReviewConverter.toEntity(member, restaurant, dto));

        // 4) 응답 DTO
        return ReviewConverter.toCreateDTO(saved);
    }
}