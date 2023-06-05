package org.coteis.repository;

import org.coteis.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoteisRepository extends JpaRepository<Article, Long> {
}
