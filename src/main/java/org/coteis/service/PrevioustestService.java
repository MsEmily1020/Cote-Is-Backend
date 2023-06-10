package org.coteis.service;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.Previoustest;
import org.coteis.repository.PrevioustestRepository;
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
