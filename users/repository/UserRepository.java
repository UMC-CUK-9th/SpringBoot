package com.example.demo.domain.users.repository;

import com.example.demo.domain.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}