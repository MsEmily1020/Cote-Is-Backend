package org.coteis.controller.category;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.category.Algorithm;
import org.coteis.dto.category.AlgorithmResponse;
import org.coteis.service.category.AlgorithmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/api/algorithms/{id}")
    public ResponseEntity<AlgorithmResponse> findAlgorithm(@PathVariable Integer id) {
        Algorithm algorithm = algorithmService.findById(id);

        return ResponseEntity.ok()
                .body(new AlgorithmResponse(algorithm));
    }
}
