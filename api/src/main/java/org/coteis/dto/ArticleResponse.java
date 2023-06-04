package org.coteis.dto;

import lombok.Getter;
import org.coteis.domain.Article;

@Getter
public class ArticleResponse {

    private final String title;
    private final String author;
    private final String date;
    private final String testExplain;
    private final String answer;
    private final String inputExample;
    private final String outputExample;
    private final String speed;
    private final String codeExplain;
    private final String concept;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.author = article.getAuthor();
        this.date = article.getDate();
        this.testExplain = article.getTestExplain();
        this.answer = article.getAnswer();
        this.inputExample = article.getInputExample();
        this.outputExample = article.getOutputExample();
        this.speed = article.getSpeed();
        this.codeExplain = article.getCodeExplain();
        this.concept = article.getConcept();
    }
}
