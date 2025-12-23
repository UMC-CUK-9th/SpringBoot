package com.example.umc9th.domain.review.service.Query;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.domain.restaurant.exception.RestaurantException;
import com.example.umc9th.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc9th.domain.restaurant.repository.RestaurantRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
// import com.example.umc9th.domain.review.dto.Res.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    // 9주차 실습 - 가게의 리뷰 목록 조회하기 API
    @Override
    public ReviewResDTO.ReviewPreViewListDTO getRestReviews(Long restId, Integer page) {

        // 1. 가게 존재 여부 검증 (ID 기준)
        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new RestaurantException(RestaurantErrorCode.REST_NOT_FOUND));

        // 2. 페이징 정보 설정 (한 페이지 10개, 프론트는 1부터 넘기므로 -1)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        // 3. 해당 가게의 리뷰 목록 조회
        Page<Review> result = reviewRepository.findAllByRestaurant(restaurant, pageRequest);

        // 4. 엔티티 → DTO 변환
        return ReviewConverter.toReviewPreviewListDTO(result);
    }

    // 9주차 미션 - 1. 내가 작성한 리뷰 목록 조회하기 API
    @Override
    public ReviewResDTO.ReviewPreViewListDTO getMyReviews(Long memberId, Integer page) {

        // 1. 회원 존재 여부 검증 (ID 기준)
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        // 2. 페이징 정보 설정 (한 페이지 10개, 프론트는 1부터 넘기므로 -1)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        // 3. 해당 회원이 작성한 리뷰 목록 조회
        Page<Review> result = reviewRepository.findAllByMember(member, pageRequest);

        // 4. 엔티티 -> DTO 변환
        return ReviewConverter.toReviewPreviewListDTO(result);
    }
}

/*
@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    // 6주차 미션 - 내가 작성한 리뷰 보기 API, QueryDSL로 구현하기
    private final ReviewRepository reviewRepository;

    // Q클래스 정의
    private static final QReview review = QReview.review;

    public List<ReviewResponseDto> searchReview(String type, String query) {

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // 아무 조건 없으면 전체 조회
        if (type == null || type.isBlank()) {
            return reviewRepository.searchReview(builder);
        }

        String t = type.toLowerCase();

        if ("region_eq".equals(t)) {
            applyRegion(builder, query);
        } else if ("grade_eq".equals(t)) {
            applyGradeExact(builder, query);
        } else if ("both_eq".equals(t)) {
            applyBoth(builder, query);
        } else if ("restaurant".equals(t)) {
            applyRestaurant(builder, query);
        } else if ("grade_band".equals(t)) {
            applyGradeBand(builder, query);
        }

        return reviewRepository.searchReview(builder);
    }

    // 지역명 필터
    private void applyRegion(BooleanBuilder builder, String regionName) {
        if (isNotBlank(regionName)) {
            builder.and(review.restaurant.region.regionName.eq(regionName));
        }
    }

    // 별점 필터
    private void applyGradeExact(BooleanBuilder builder, String gradeStr) {
        if (isNotBlank(gradeStr)) {
            try {
                int grade = Integer.parseInt(gradeStr);
                builder.and(review.grade.eq(grade));
            } catch (NumberFormatException ignored) {}
        }
    }

    // 지역명&별점 필터
    private void applyBoth(BooleanBuilder builder, String query) {
        if (query == null || query.isBlank()) return;
        String[] parts = query.split("&", 2);

        applyRegion(builder, parts.length > 0 ? parts[0] : null);
        applyGradeExact(builder, parts.length > 1 ? parts[1] : null);
    }

    // 가게 이름 필터
    private void applyRestaurant(BooleanBuilder builder, String name) {
        if (isNotBlank(name)) {
            builder.and(review.restaurant.restName.eq(name));
        }
    }

    // 별점대 필터
    private void applyGradeBand(BooleanBuilder builder, String bandStr) {
        if (bandStr == null || bandStr.isBlank()) return;

        try {
            int band = Integer.parseInt(bandStr);
            if (band == 5) {
                builder.and(review.grade.eq(5));
            } else if (band >= 1 && band <= 4) {
                builder.and(review.grade.goe(band).and(review.grade.lt(band + 1)));
            }
        } catch (NumberFormatException ignored) {}
    }

    private boolean isNotBlank(String s) {
        return s != null && !s.isBlank();
    }
}
 */