package com.example.demo.domain.members.repository;

import com.example.demo.domain.members.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Members, Long> {
}