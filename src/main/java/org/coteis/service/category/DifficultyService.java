package org.coteis.service.category;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.category.Difficulty;
import org.coteis.repository.category.DifficultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DifficultyService {

    private final DifficultyRepository difficultyRepository;

    public List<Difficulty> findAll() {
        return difficultyRepository.findAll();
    }
}