package com.example.umc9th.domain.user.entity;

import com.example.umc9th.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 5, nullable = false)
    private String userName;

    @Column(length = 10, nullable = false)
    private String nickname;

    @Column(name = "user_password", length = 15, nullable = false)
    private String userPassword;

    @Column(length = 25, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private UserStatus userStatus;

    @Column
    private Long user_point;

    @Column
    private LocalDateTime inactive_date;

    @Column(name = "user_phone_number", length = 15, nullable = false)
    private String userPhoneNumber;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Review> stores = new ArrayList<>();
}
