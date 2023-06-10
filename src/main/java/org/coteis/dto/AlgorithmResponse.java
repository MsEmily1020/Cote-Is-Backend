package org.coteis.dto;


import lombok.Getter;
import org.coteis.domain.Algorithm;

@Getter
public class AlgorithmResponse {

    private final Integer algorithmNo;
    private final String algorithmName;

    public AlgorithmResponse(Algorithm algorithm){
        this.algorithmNo = algorithm.getAlgorithmNo();
        this.algorithmName = algorithm.getAlgorithmName();
    }
}
