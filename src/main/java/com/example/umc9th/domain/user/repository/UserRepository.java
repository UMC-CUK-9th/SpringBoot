package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //5주차 마이 페이지 화면 메서드 생성 방식 JPQL
    //조회는 service 단에서
}
