package com.example.demo.domain.qnas.entity.mapping;

import com.example.demo.domain.qnas.entity.QnAs;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "qna_images")

public class QnAImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_image_id", nullable = false)
    private Long qnaImageId;

    @Column(name = "qna_url", nullable = false)
    private String qnaUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qna_id", nullable = false)
    private QnAs qnas;
}
