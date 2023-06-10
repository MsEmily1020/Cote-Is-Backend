package org.coteis.dto;

import lombok.Getter;
import org.coteis.domain.Algorithm;
import org.coteis.domain.Difficulty;

@Getter
public class DifficultyResponse {

    private final Integer difficultyNo;
    private final String difficultyName;

    public DifficultyResponse(Difficulty difficulty){
        this.difficultyNo = difficulty.getDifficultyNo();
        this.difficultyName = difficulty.getDifficultyName();
    }
}
