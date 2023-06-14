package org.coteis.service.article;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.coteis.domain.article.Article;
import org.coteis.dto.article.AddArticleRequest;
import org.coteis.dto.article.UpdateArticleRequest;
import org.coteis.repository.article.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    // create
    public Article save(AddArticleRequest request){
        return articleRepository.save(request.toEntity());
    }

    // read
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    // delete
    public void delete(long id) { articleRepository.deleteById(id); }

    // update
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
