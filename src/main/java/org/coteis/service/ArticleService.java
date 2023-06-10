package org.coteis.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.coteis.domain.Article;
import org.coteis.dto.AddArticleRequest;
import org.coteis.dto.UpdateArticleRequest;
import org.coteis.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article save(AddArticleRequest request){
        return articleRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public void delete(long id) { articleRepository.deleteById(id); }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(),
                request.getAuthor(),
                request.getDate(),
                request.getTestExplain(),
                request.getAnswer(),
                request.getInputExample(),
                request.getOutputExample(),
                request.getSpeed(),
                request.getCodeExplain(),
                request.getConcept()
                );

        return article;
    }
}
