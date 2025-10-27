package com.example.demo.domain.users.entity.mapping;

import com.example.demo.domain.users.entity.Preferences;
import com.example.demo.domain.users.entity.Users;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "user_preferences")

public class UserPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_pre_id", nullable = false)
    private Long userPreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pre_id", nullable = false)
    private Preferences preferences;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
}
