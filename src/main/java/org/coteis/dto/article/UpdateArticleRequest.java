package org.coteis.dto.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Difficulty;
import org.coteis.domain.category.Language;
import org.coteis.domain.category.Previoustest;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateArticleRequest {
    private String title;
    private String testExplain;
    private String answer;
    private String inputExample;
    private String outputExample;
    private String speed;
    private String codeExplain;
    private String concept;
    private Algorithm algorithmNo;
    private Difficulty difficultyNo;
    private Language languageNo;
    private Previoustest previoustestNo;
}
