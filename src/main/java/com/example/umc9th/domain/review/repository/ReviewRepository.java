package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    //5주차 리뷰 작성하는 메서드 생성 방식JPQL 사진은 배제함
    //insert는 service 단에서 구현
}
