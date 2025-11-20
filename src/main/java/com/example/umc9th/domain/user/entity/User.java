package com.example.umc9th.domain.user.entity;

import com.example.umc9th.domain.user.entity.mapping.UserFood;
import com.example.umc9th.domain.user.entity.mapping.UserTerm;
import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.domain.user.enums.SocialType;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "tb_user") //4주차 피드백 user 이름 변경 -> tb_user
public class User extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //스웨거에서 계속 null오류 떠서 일단 null 허용으로 바꿨습니다
    @Column(name = "name" , length = 3)
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "address")
    private String address;

    @Column(name = "detail_address")
    private String detailAddress;

    @Column(name = "social_uid")
    private String socialUid;

    @Column(name = "social_type")
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(name = "point")
    @Builder.Default
    private Integer point = 0;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "email", length = 30)
    private String email;



}
