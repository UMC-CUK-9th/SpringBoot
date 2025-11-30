package com.example.demo.domain.members.entity;

import com.example.demo.domain.missions.entity.mapping.MemberMissions;
import com.example.demo.domain.members.entity.mapping.MemberPreferences;
import com.example.demo.domain.qnas.entity.QnAs;
import com.example.demo.domain.members.entity.mapping.MemberTerms;
import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.members.enums.Gender;
import com.example.demo.global.auth.enums.SocialType;
import com.example.demo.global.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "members")

public class Members extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId", nullable = false)
    private Long memberId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "profileImage")
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

    @Column(name = "isPhoneVerified", nullable = false)
    @Builder.Default
    private Boolean isPhoneVerified = false;

    @Column(name = "isActive", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @Column(name = "inactiveUntil")
    private LocalDateTime inactiveUntil;

    @JsonIgnore
    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Reviews> reviewsList = new ArrayList<>();

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberTerms> memberTermsList = new ArrayList<>();

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    @Builder.Default
    private List<QnAs> qnasList = new ArrayList<>();

    @OneToOne(mappedBy = "members", cascade = CascadeType.ALL)
    private Notifications notifications;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberPreferences> memberPreferencesList = new ArrayList<>();

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberMissions> memberMissionList = new ArrayList<>();
}