package org.coteis.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Algorithm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "algorithm_no", updatable = false)
    private Integer algorithmNo;

    @Column(name = "algorithm_name", nullable = false)  // 알고리즘 종류
    private String algorithmName;

    @Builder
    public Algorithm(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
