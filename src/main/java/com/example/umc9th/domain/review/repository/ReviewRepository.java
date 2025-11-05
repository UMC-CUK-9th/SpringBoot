package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom{
    //5주차 리뷰 작성하는 메서드 생성 방식JPQL 사진은 배제함
    //5주차 피드백 메서드 구현
    //이후 수정/삭제 때 본인 글인지 확인, insert 자체는 후에 service단의 save()로 구현
    Optional<Review> findByIdAndUserIdAndDeletedAtIsNull(Long reviewId, Long userId);
}
