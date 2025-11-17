package com.example.demo.domain.members.entity.mapping;

import com.example.demo.domain.members.entity.Members;
import com.example.demo.domain.members.entity.Preferences;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "memberPreferences")

public class MemberPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberPreId", nullable = false)
    private Long memberPreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preId", nullable = false)
    private Preferences preferences;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", nullable = false)
    private Members members;
}
