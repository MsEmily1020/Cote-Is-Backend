package org.coteis.dto.category;


import lombok.Getter;
import org.coteis.domain.category.Algorithm;

@Getter
public class AlgorithmResponse {

    private final Integer algorithmNo;
    private final String algorithmName;

    public AlgorithmResponse(Algorithm algorithm){
        this.algorithmNo = algorithm.getAlgorithmNo();
        this.algorithmName = algorithm.getAlgorithmName();
    }
}
