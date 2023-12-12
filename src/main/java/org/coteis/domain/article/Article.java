package org.coteis.domain.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.BaseTimeEntity;
import org.coteis.domain.category.Algorithm;
import org.coteis.domain.category.Difficulty;
import org.coteis.domain.category.Language;
import org.coteis.domain.category.Previoustest;
import org.coteis.domain.comment.Comment;
import org.coteis.domain.user.User;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_no", updatable = false)
    private Long articleNo;

    @Column(name = "title", nullable = false)   // 제목
    private String title;

    @Column(name = "test_explain", nullable = false, columnDefinition = "LONGTEXT")    // 문제 설명
    private String testExplain;

    @Column(name = "answer", nullable = false, columnDefinition = "LONGTEXT")  // 코드 해답
    private String answer;

    @Column(name = "input_example", columnDefinition = "LONGTEXT") // 입력 예
    private String inputExample;

    @Column(name = "output_example", columnDefinition = "LONGTEXT")    // 출력 예
    private String outputExample;

    @Column(name = "speed") // 최적화,속도
    private String speed;

    @Column(name = "code_explain", columnDefinition = "LONGTEXT")  // 코드 설명
    private String codeExplain;

    @Column(name = "concept", columnDefinition = "LONGTEXT")   // 개념 정리
    private String concept;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_no")
    private User userNo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "algorithm_no")
    private Algorithm algorithmNo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "difficulty_no")
    private Difficulty difficultyNo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "language_no")
    private Language languageNo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "previoustest_no")
    private Previoustest previoustestNo;

    @JsonIgnore
    @OneToMany(mappedBy = "articleNo", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Comment> commentList;

    @Builder
    public Article(String title, String testExplain, String answer, String inputExample, String outputExample, String speed, String codeExplain, String concept,
                   User userNo, Algorithm algorithmNo, Difficulty difficultyNo, Language languageNo, Previoustest previoustestNo) {
        this.title = title;
        this.testExplain = testExplain;
        this.answer = answer;
        this.inputExample = inputExample;
        this.outputExample = outputExample;
        this.speed = speed;
        this.codeExplain = codeExplain;
        this.concept = concept;
        this.userNo = userNo;
        this.algorithmNo = algorithmNo;
        this.difficultyNo = difficultyNo;
        this.languageNo = languageNo;
        this.previoustestNo = previoustestNo;
    }

    public void update(String title,
                       String testExplain,
                       String answer,
                       String inputExample,
                       String outputExample,
                       String speed,
                       String codeExplain,
                       String concept,
                       Algorithm algorithmNo,
                       Difficulty difficultyNo,
                       Language languageNo,
                       Previoustest previoustestNo) {

        this.title = title;
        this.testExplain = testExplain;
        this.answer = answer;
        this.inputExample = inputExample;
        this.outputExample = outputExample;
        this.speed = speed;
        this.codeExplain = codeExplain;
        this.concept = concept;
        this.algorithmNo = algorithmNo;
        this.difficultyNo = difficultyNo;
        this.languageNo = languageNo;
        this.previoustestNo = previoustestNo;
    }
}
