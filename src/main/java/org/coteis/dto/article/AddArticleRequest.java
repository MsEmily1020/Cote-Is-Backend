package org.coteis.dto.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.article.Article;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Difficulty;
import org.coteis.domain.category.Language;
import org.coteis.domain.category.Previoustest;
import org.coteis.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String testExplain;
    private String answer;
    private String inputExample;
    private String outputExample;
    private String speed;
    private String codeExplain;
    private String concept;
    private User userNo;
    private Algorithm algorithmNo;
    private Difficulty difficultyNo;
    private Language languageNo;
    private Previoustest previoustestNo;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .testExplain(testExplain)
                .answer(answer)
                .inputExample(inputExample)
                .outputExample(outputExample)
                .speed(speed)
                .codeExplain(codeExplain)
                .concept(concept)
                .userNo(userNo)
                .algorithmNo(algorithmNo)
                .difficultyNo(difficultyNo)
                .languageNo(languageNo)
                .previoustestNo(previoustestNo)
                .build();
    }
}
