package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<User,Long>{
    List<UserInfoDto> findStoreBasicInfo();
//    @Query("SELECT new com.example.umc9th.domain.user.dto.UserInfoDto(u.name, u.email, u.phoneNumber, u.point) FROM User u")
//    List<UserInfoDto> findUserBasicInfo();
}
