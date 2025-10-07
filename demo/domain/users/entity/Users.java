package com.example.demo.domain.users.entity;

import com.example.demo.domain.missions.entity.mapping.UserMissions;
import com.example.demo.domain.users.entity.mapping.UserPreferences;
import com.example.demo.domain.users.entity.Notifications;
import com.example.demo.domain.qnas.entity.QnAs;
import com.example.demo.domain.users.entity.mapping.UserTerms;
import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.users.enums.Gender;
import com.example.demo.global.auth.enums.SocialType;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")

public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "profile_image")
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "log_type", nullable = false)
    private SocialType logType;   // kakao, google, apple, naver

    @Column(name = "point", nullable = false)
    private Integer point;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;  // male, female, other

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "is_phone_verified", nullable = false)
    @Builder.Default
    private Boolean isPhoneVerified = false;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @Column(name = "inactive_until")
    private LocalDateTime inactiveUntil;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Reviews> reviewsList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @Builder.Default
    private List<UserTerms> userTermsList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @Builder.Default
    private List<QnAs> qnasList = new ArrayList<>();

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Notifications notifications;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @Builder.Default
    private List<UserPreferences> userPreferencesList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @Builder.Default
    private List<UserMissions> userMissionList = new ArrayList<>();
}