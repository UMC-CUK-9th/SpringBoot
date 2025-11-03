package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 5주차 미션 - 2. 마이 페이지 화면 쿼리
    // 5주차 피드백 반영 - @query 어노테이션 사용
    @Query("SELECT m FROM Member m WHERE m.id = :id")
    Optional<Member> findMemberProfileById(@Param("id") Long id);
}
