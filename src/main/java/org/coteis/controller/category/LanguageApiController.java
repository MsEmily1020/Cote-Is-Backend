package org.coteis.controller.category;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Language;
import org.coteis.dto.category.AlgorithmResponse;
import org.coteis.dto.category.LanguageResponse;
import org.coteis.service.category.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LanguageApiController {

    private final LanguageService languageService;

    @GetMapping("/api/languages")
    public ResponseEntity<List<LanguageResponse>> findAllLanguages(){
        List<LanguageResponse> responses = languageService.findALl()
                .stream()
                .map(LanguageResponse::new)
                .toList();
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/api/languages/{id}")
    public ResponseEntity<LanguageResponse> findLanguage(@PathVariable Integer id) {
        Language language = languageService.findById(id);

        return ResponseEntity.ok()
                .body(new LanguageResponse(language));
    }
}
