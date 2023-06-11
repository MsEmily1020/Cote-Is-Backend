package org.coteis.dto.category;

import lombok.Getter;
import org.coteis.domain.category.Difficulty;

@Getter
public class DifficultyResponse {

    private final Integer difficultyNo;
    private final String difficultyName;

    public DifficultyResponse(Difficulty difficulty){
        this.difficultyNo = difficulty.getDifficultyNo();
        this.difficultyName = difficulty.getDifficultyName();
    }
}
