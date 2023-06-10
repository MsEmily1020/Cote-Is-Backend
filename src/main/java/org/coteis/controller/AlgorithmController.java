package org.coteis.controller;

import lombok.RequiredArgsConstructor;
import org.coteis.dto.AlgorithmResponse;
import org.coteis.dto.ArticleResponse;
import org.coteis.service.AlgorithmService;
import org.coteis.service.CoteisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class AlgorithmController {
    private final AlgorithmService algorithmService;

    @GetMapping("/api/algorithms")
    public ResponseEntity<List<AlgorithmResponse>> findAllArticles(){
        List<AlgorithmResponse> algorithms = algorithmService.findAll()
                .stream()
                .map(AlgorithmResponse::new)
                .toList();

        return ResponseEntity.ok().body(algorithms);
    }
}
