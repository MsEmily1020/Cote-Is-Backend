package org.coteis.repository.article;

import org.coteis.domain.article.Article;
import org.coteis.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByUserNo(User userNo);
}
