package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // List<Member> findByNameAndDeletedAtIsNull(String name);

    // 5주차 미션 - 2. 마이 페이지 화면 쿼리
    // 5주차 피드백 반영 - @query 어노테이션 사용
    @Query("select m from Member m where m.name = :name and m.inactiveDate is null")
    List<Member> findActiveMember(@Param("name") String name);
}