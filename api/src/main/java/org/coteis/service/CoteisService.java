package org.coteis.service;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.Article;
import org.coteis.dto.AddArticleRequest;
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
}
