package com.example.demo.domain.members.repository;

import com.example.demo.domain.members.entity.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository extends JpaRepository<Preferences, Long> {
}
