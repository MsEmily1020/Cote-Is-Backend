package org.coteis.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Previoustest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "previoustest_no", updatable = false)
    private Integer previoustestNo;

    @Column(name = "previoustest_name", nullable = false)
    private String previoustestName;

    @Builder
    public Previoustest(String previoustestName) {
        this.previoustestName = previoustestName;
    }
}
