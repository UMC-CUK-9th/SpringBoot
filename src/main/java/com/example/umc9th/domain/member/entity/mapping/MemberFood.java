package com.example.umc9th.domain.member.entity.mapping;

import com.example.umc9th.domain.member.entity.Food;
import com.example.umc9th.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member_food")
public class MemberFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 1:N 관계에서 이 엔티티가 1임을 정의 (지연 로딩)
    @JoinColumn(name = "member_id", nullable = false) // FK의 주인을 설정
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY) // 1:N 관계에서 이 엔티티가 1임을 정의 (지연 로딩)
    @JoinColumn(name = "food_id", nullable = false) // FK의 주인을 설정
    private Food food;

}
