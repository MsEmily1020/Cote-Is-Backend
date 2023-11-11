package org.coteis.service.category;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Difficulty;
import org.coteis.repository.category.DifficultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DifficultyService {

    private final DifficultyRepository difficultyRepository;

    // read
    public List<Difficulty> findAll() {
        return difficultyRepository.findAll();
    }

    public Difficulty findById(Integer id) {
        return difficultyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}