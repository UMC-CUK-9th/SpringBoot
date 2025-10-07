package com.example.demo.domain.users.entity;

import com.example.demo.domain.users.entity.Users;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "notifications")

public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noti_id", nullable = false)
    private Long notiId;

    @Column(name = "noti_event", nullable = false)
    private Boolean event;

    @Column(name = "noti_review", nullable = false)
    private Boolean review;

    @Column(name = "noti_response", nullable = false)
    private Boolean response;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
}
