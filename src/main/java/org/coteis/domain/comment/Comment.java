package org.coteis.domain.comment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.BaseTimeEntity;
import org.coteis.domain.article.Article;
import org.coteis.domain.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", updatable = false)
    private Long commentId;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User userNo;

    @ManyToOne
    @JoinColumn(name = "article_no")
    private Article articleNo;

    @Builder
    public Comment(String content, User userNo, Article articleNo) {
        this.content = content;
        this.userNo = userNo;
        this.articleNo = articleNo;
    }

    public void update(String content) { this.content = content; }
}
