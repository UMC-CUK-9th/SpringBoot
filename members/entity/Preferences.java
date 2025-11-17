package com.example.demo.domain.members.entity;

import com.example.demo.domain.members.entity.mapping.MemberPreferences;
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
    @Column(name = "preId", nullable = false)
    private Long preId;

    @Column(name = "preType", nullable = false)
    private Integer preType; // 0 : 한식 ~ 11 : 아시안푸드

    @OneToMany(mappedBy = "preferences", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberPreferences> memberPreferencesList = new ArrayList<>();
}