package org.coteis.repository.article;

import org.coteis.domain.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
