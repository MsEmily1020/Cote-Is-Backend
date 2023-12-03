package org.coteis.dto.comment;

import lombok.Getter;
import org.coteis.domain.article.Article;
import org.coteis.domain.comment.Comment;
import org.coteis.domain.user.User;

@Getter
public class CommentResponse {
    private final Long commentId;
    private final String content;
    private final User userNo;
    private final Article articleNo;

    public CommentResponse(Comment comment) {
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
        this.userNo = comment.getUserNo();
        this.articleNo = comment.getArticleNo();
    }
}
