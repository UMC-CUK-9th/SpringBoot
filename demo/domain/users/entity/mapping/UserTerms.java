package com.example.demo.domain.users.entity.mapping;

import com.example.demo.domain.users.entity.Terms;
import com.example.demo.domain.users.entity.Users;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "userterms")

public class UserTerms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_term_id", nullable = false)
    private Long userTermId;

    @Column(name = "is_agredd", nullable = false)
    private Boolean isAgredd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id", nullable = false)
    private Terms terms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
}
