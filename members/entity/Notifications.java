package com.example.demo.domain.members.entity;

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
    @Column(name = "notiId", nullable = false)
    private Long notiId;

    @Column(name = "notiEvent", nullable = false)
    private Boolean event;

    @Column(name = "notiReview", nullable = false)
    private Boolean review;

    @Column(name = "notiResponse", nullable = false)
    private Boolean response;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", nullable = false)
    private Members members;
}
