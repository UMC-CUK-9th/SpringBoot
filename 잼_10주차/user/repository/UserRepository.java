package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{
    List<UserInfoDto> findStoreBasicInfo();

    Optional<User> findByEmail(String email);

    Optional<User> findByUserName(String name);

    List<UserInfoDto> findUserInfoById(Long userId);

    String email(String email);

//    @Query("SELECT new com.example.umc9th.domain.user.dto.UserInfoDto(u.name, u.email, u.phoneNumber, u.point) FROM User u")
//    List<UserInfoDto> findUserBasicInfo();
}
