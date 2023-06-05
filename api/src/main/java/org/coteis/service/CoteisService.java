package org.coteis.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.coteis.domain.Article;
import org.coteis.dto.AddArticleRequest;
import org.coteis.dto.UpdateArticleRequest;
import org.coteis.repository.CoteisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CoteisService {

    private final CoteisRepository coteisRepository;

    public Article save(AddArticleRequest request){
        return coteisRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return coteisRepository.findAll();
    }

    public void delete(long id) { coteisRepository.deleteById(id); }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = coteisRepository.findById(id)
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
