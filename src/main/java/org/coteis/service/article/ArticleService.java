package org.coteis.service.article;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.coteis.domain.article.Article;
import org.coteis.domain.user.User;
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

    public Article findById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // delete
    public void delete(Long id) { articleRepository.deleteById(id); }

    // update
    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(
                request.getTitle(),
                request.getTestExplain(),
                request.getAnswer(),
                request.getInputExample(),
                request.getOutputExample(),
                request.getSpeed(),
                request.getCodeExplain(),
                request.getConcept(),
                request.getAlgorithmNo(),
                request.getDifficultyNo(),
                request.getLanguageNo(),
                request.getPrevioustestNo()
                );

        return article;
    }
}
