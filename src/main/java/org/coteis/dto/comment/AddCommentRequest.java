package org.coteis.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.article.Article;
import org.coteis.domain.comment.Comment;
import org.coteis.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCommentRequest {
    private String content;
    private User userNo;
    private Article articleNo;

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .userNo(userNo)
                .articleNo(articleNo)
                .build();
    }
}
