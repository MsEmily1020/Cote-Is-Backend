package org.coteis.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {
    private String userName;
    private String userId;
    private String userPw;
    private String userEmail;

    public User toEntity(){
        return User.builder()
                .userName(userName)
                .userId(userId)
                .userPw(userPw)
                .userEmail(userEmail)
                .build();

    }
}

