package org.coteis.service;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.Algorithm;
import org.coteis.repository.AlgorithmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlgorithmService {

    private final AlgorithmRepository algorithmRepository;

    public List<Algorithm> findAll() {
        return algorithmRepository.findAll();
    }
}
