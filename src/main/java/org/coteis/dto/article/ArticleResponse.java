package org.coteis.dto.article;

import lombok.Getter;
import org.coteis.domain.article.Article;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Difficulty;
import org.coteis.domain.category.Language;
import org.coteis.domain.category.Previoustest;
import org.coteis.domain.user.User;

import java.time.LocalDateTime;

@Getter
public class ArticleResponse {

    private final Long articleNo;
    private final String title;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
    private final String testExplain;
    private final String answer;
    private final String inputExample;
    private final String outputExample;
    private final String speed;
    private final String codeExplain;
    private final String concept;
    private final User userNo;
    private final Algorithm algorithmNo;
    private final Difficulty difficultyNo;
    private final Language languageNo;
    private final Previoustest previoustestNo;

    public ArticleResponse(Article article){
        this.articleNo = article.getArticleNo();
        this.title = article.getTitle();
        this.createdDate = article.getCreatedDate();
        this.modifiedDate = article.getModifiedDate();
        this.testExplain = article.getTestExplain();
        this.answer = article.getAnswer();
        this.inputExample = article.getInputExample();
        this.outputExample = article.getOutputExample();
        this.speed = article.getSpeed();
        this.codeExplain = article.getCodeExplain();
        this.concept = article.getConcept();
        this.userNo = article.getUserNo();
        this.algorithmNo = article.getAlgorithmNo();
        this.difficultyNo = article.getDifficultyNo();
        this.languageNo = article.getLanguageNo();
        this.previoustestNo = article.getPrevioustestNo();
    }
}
