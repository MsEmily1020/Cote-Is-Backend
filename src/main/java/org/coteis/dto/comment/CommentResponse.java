package org.coteis.dto.comment;

import lombok.Getter;
import org.coteis.domain.article.Article;
import org.coteis.domain.comment.Comment;
import org.coteis.domain.user.User;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {
    private final Long commentId;
    private final String content;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
    private final User userNo;
    private final Article articleNo;

    public CommentResponse(Comment comment) {
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
        this.createdDate = comment.getCreatedDate();
        this.modifiedDate = comment.getModifiedDate();
        this.userNo = comment.getUserNo();
        this.articleNo = comment.getArticleNo();
    }
}
