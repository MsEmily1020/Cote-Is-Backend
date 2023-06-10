package org.coteis.service;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.Algorithm;
import org.coteis.domain.Difficulty;
import org.coteis.repository.AlgorithmRepository;
import org.coteis.repository.DifficultyRepository;
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