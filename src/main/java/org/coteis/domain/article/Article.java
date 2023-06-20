package org.coteis.domain.article;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_no", updatable = false)
    private Long articleNo;

    @Column(name = "title", nullable = false)   // 제목
    private String title;

    @Column(name = "author", nullable = false)  // 작성자
    private String author;

    @Column(name = "date", nullable = false)  // 게시 날짜
    private String date;

    @Column(name = "test_explain", nullable = false)    // 문제 설명
    private String testExplain;

    @Column(name = "answer", nullable = false)  // 코드 해답
    private String answer;

    @Column(name = "input_example") // 입력 예
    private String inputExample;

    @Column(name = "output_example")    // 출력 예
    private String outputExample;

    @Column(name = "speed") // 최적화,속도
    private String speed;

    @Column(name = "code_explain")  // 코드 설명
    private String codeExplain;

    @Column(name = "concept")   // 개념 정리
    private String concept;

    @Builder
    public Article(String title, String author, String date, String testExplain, String answer, String inputExample, String outputExample, String speed, String codeExplain, String concept) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.testExplain = testExplain;
        this.answer = answer;
        this.inputExample = inputExample;
        this.outputExample = outputExample;
        this.speed = speed;
        this.codeExplain = codeExplain;
        this.concept = concept;
    }

    public void update(String title,
                       String author,
                       String date,
                       String testExplain,
                       String answer,
                       String inputExample,
                       String outputExample,
                       String speed,
                       String codeExplain,
                       String concept) {

        this.title = title;
        this.author = author;
        this.date = date;
        this.testExplain = testExplain;
        this.answer = answer;
        this.inputExample = inputExample;
        this.outputExample = outputExample;
        this.speed = speed;
        this.codeExplain = codeExplain;
        this.concept = concept;

    }
}
