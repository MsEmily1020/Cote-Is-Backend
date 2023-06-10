package org.coteis.controller;

import lombok.RequiredArgsConstructor;
import org.coteis.dto.DifficultyResponse;
import org.coteis.service.DifficultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class DifficultyController {
    private final DifficultyService difficultyService;

    @GetMapping("/api/difficulties")
    public ResponseEntity<List<DifficultyResponse>> findAllArticles(){
        List<DifficultyResponse> difficulties = difficultyService.findAll()
                .stream()
                .map(DifficultyResponse::new)
                .toList();

        return ResponseEntity.ok().body(difficulties);
    }
}
