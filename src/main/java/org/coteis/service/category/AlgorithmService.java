package org.coteis.service.category;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.user.User;
import org.coteis.repository.category.AlgorithmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlgorithmService {

    private final AlgorithmRepository algorithmRepository;

    // read
    public List<Algorithm> findAll() {
        return algorithmRepository.findAll();
    }

    public Algorithm findById(Integer id) {
        return algorithmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
