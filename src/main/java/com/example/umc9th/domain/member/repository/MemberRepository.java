package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    // 5주차 미션 - 2. 마이 페이지 화면 쿼리
    Optional<Member> findById(Long id);
}
