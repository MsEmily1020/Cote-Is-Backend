package org.coteis.controller;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.Article;
import org.coteis.dto.AddArticleRequest;
import org.coteis.dto.ArticleResponse;
import org.coteis.dto.UpdateArticleRequest;
import org.coteis.service.CoteisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CoteisApiController {

    private final CoteisService coteisService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = coteisService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = coteisService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok().body(articles);
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = coteisService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        coteisService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}
