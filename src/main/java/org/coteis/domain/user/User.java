package org.coteis.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.article.Article;
import org.coteis.domain.comment.Comment;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", updatable = false)
    private Long userNo;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "user_pw", nullable = false)
    private String userPw;

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @JsonIgnore
    @OneToMany(mappedBy = "userNo", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Article> articleList;

    @JsonIgnore
    @OneToMany(mappedBy = "userNo", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Comment> commentList;

    @Builder
    public User(String userName, String userId, String userPw, String userEmail) {
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
    }

    public void update(String userName,
                       String userId,
                       String userPw,
                       String userEmail) {

        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
    }
}
