package com.example.demo.domain.members.entity;

import com.example.demo.domain.members.entity.mapping.MemberTerms;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "terms")

public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "termId", nullable = false)
    private Long termId;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberTerms> memberTermsList = new ArrayList<>();
}
