package org.coteis.repository;

import org.coteis.domain.Algorithm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlgorithmRepository extends JpaRepository<Algorithm, Integer> {
}
