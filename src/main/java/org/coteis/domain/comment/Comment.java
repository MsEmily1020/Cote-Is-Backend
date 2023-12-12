package org.coteis.domain.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.BaseTimeEntity;
import org.coteis.domain.article.Article;
import org.coteis.domain.user.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.DeleteMapping;

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

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_no")
    private User userNo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
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
