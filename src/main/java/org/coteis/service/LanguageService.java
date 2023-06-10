package org.coteis.service;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.Language;
import org.coteis.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public List<Language> findALl(){
        return languageRepository.findAll();
    }
}
