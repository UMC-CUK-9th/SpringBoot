package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.inquiry.entity.Inquiry;
import com.example.umc9th.domain.member.entity.mapping.MemberFoodType;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.entity.mapping.MemberNotification;
import com.example.umc9th.domain.member.entity.mapping.MemberTerms;
import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.Login;
import com.example.umc9th.domain.member.enums.Status;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // 이 클래스가 JPA의 엔티티임을 의미한다.
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 자동으로 생성한다.
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member") // DB의 테이블을 정의한다.
// @EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity {

    @Id // DB의 PK 부분을 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생성 전략을 선택한다. IDENTITY인 경우, 순차적 생성(1 → 2 → …)을 의미한다.
    private Long id;

    @Column(name = "login", nullable = false)
    @Enumerated(EnumType.STRING) // Enum을 사용할 때, 데이터의 형태를 명시화한다.
    private Login login;

    @Column(name = "name", length = 10, nullable = false) // DB의 속성 부분을 의미한다.
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default // 초기값을 지정한다.
    private Gender gender = Gender.MALE;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "address", columnDefinition = "TEXT", nullable = false)
    private String address;

    @Column(name = "nickname", length = 20, nullable = false)
    private String nickname;

    @Column(name = "email", columnDefinition = "TEXT", nullable = false)
    private String email;

    @Column(name = "phone_num", length = 15, nullable = false)
    private String phone_num;

    @Column(name = "point")
    private Long point;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "inactiveDate")
    private LocalDateTime inactiveDate;

    // 연관관계 매핑
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberMission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberTerms> terms = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberFoodType> foodTypes = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<MemberNotification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Inquiry> inquiries = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();
}
