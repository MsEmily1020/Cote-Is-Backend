package org.coteis.controller;

import lombok.RequiredArgsConstructor;
import org.coteis.dto.LanguageResponse;
import org.coteis.service.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LanguageApiController {

    private final LanguageService languageService;

    @GetMapping("api/languages")
    public ResponseEntity<List<LanguageResponse>> findAllLanguages(){
        List<LanguageResponse> responses = languageService.findALl()
                .stream()
                .map(LanguageResponse::new)
                .toList();
        return ResponseEntity.ok().body(responses);
    }
}
