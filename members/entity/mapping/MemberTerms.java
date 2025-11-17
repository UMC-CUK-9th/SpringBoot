package com.example.demo.domain.members.entity.mapping;

import com.example.demo.domain.members.entity.Terms;
import com.example.demo.domain.members.entity.Members;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "memberTerms")

public class MemberTerms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberTermId", nullable = false)
    private Long memberTermId;

    @Column(name = "isAgredd", nullable = false)
    private Boolean isAgred;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "termId", nullable = false)
    private Terms terms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", nullable = false)
    private Members members;
}
