package org.coteis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateArticleRequest {
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
}
