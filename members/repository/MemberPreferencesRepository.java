package com.example.demo.domain.members.repository;

import com.example.demo.domain.members.entity.mapping.MemberPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPreferencesRepository extends JpaRepository<MemberPreferences, Long> {
}
