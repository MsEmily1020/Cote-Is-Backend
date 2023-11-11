package org.coteis.service.category;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Previoustest;
import org.coteis.repository.category.PrevioustestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PrevioustestService {
    private final PrevioustestRepository previoustestRepository;

    // read
    public List<Previoustest> findAll(){
        return previoustestRepository.findAll();
    }

    public Previoustest findById(Integer id) {
        return previoustestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
