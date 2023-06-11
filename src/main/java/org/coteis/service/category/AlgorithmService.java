package org.coteis.service.category;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.category.Algorithm;
import org.coteis.repository.category.AlgorithmRepository;
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
