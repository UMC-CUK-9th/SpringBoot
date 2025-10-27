package com.example.demo.domain.users.entity;

import com.example.demo.domain.users.entity.mapping.UserPreferences;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "preferences")

public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pre_id", nullable = false)
    private Long preId;

    @Column(name = "pre_type", nullable = false)
    private Integer preType; // 0 : 한식 ~ 11 : 아시안푸드

    @OneToMany(mappedBy = "preferences", cascade = CascadeType.ALL)
    @Builder.Default
    private List<UserPreferences> userPreferencesList = new ArrayList<>();
}
