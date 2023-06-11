package org.coteis.service.category;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.category.Previoustest;
import org.coteis.repository.category.PrevioustestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PrevioustestService {
    private final PrevioustestRepository previoustestRepository;

    public List<Previoustest> findAll(){
        return previoustestRepository.findAll();
    }
}
