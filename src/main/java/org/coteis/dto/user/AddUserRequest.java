package org.coteis.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.coteis.domain.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddUserRequest {
    private String userName;
    private String userId;
    private String userPw;
    private String userEmail;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User toEntity(){
        return User.builder()
                .userName(userName)
                .userId(userId)
                .userPw(bCryptPasswordEncoder.encode(userPw))
                .userEmail(userEmail)
                .build();
    }
}

