package com.example.demo.domain.qnas.entity;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.domain.qnas.entity.mapping.QnAImages;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "qnas")

public class QnAs extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_id", nullable = false)
    private Long qnaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "is_response", nullable = false)
    @Builder.Default
    private Boolean isResponse = false;

    @OneToMany(mappedBy = "qnas", cascade = CascadeType.ALL)
    @Builder.Default
    private List<QnAImages> qnasImages = new ArrayList<>();
}
