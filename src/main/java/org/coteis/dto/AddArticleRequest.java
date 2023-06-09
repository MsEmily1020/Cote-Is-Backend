package org.coteis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.Article;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String author;
    private String date;
    private String testExplain;
    private String answer;
    private String inputExample;
    private String outputExample;
    private String speed;
    private String codeExplain;
    private String concept;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .answer(answer)
                .author(author)
                .codeExplain(codeExplain)
                .concept(concept)
                .date(date)
                .inputExample(inputExample)
                .outputExample(outputExample)
                .speed(speed)
                .testExplain(testExplain)
                .concept(concept)
                .build();
    }
}
