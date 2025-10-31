package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //5주차 마이 페이지 화면 메서드 생성 방식 JPQL
    //5주차 피드백 메서드 구현
    //사용자의 마이페이지 조회 쿼리이므로 "현재 로그인한 1명"의 유저 조희이므로 List 대신 Optional 사용"
    //소프트 deleted 되지 않은 유저만 조회
    Optional<User> findByIdAndDeletedAtIsNull(Long id);
}
