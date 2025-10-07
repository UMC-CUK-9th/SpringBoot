package com.example.demo.domain.stores.entity.mapping;

import com.example.demo.domain.stores.entity.Stores;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "categories")

public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id", nullable = false)
    private Long cateId;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Stores> storesList = new ArrayList<>();
}
