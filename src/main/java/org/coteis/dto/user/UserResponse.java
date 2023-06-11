package org.coteis.dto.user;

import lombok.Getter;
import org.coteis.domain.user.User;

@Getter
public class UserResponse {
    private final Long userNo;
    private final String userName;
    private final String userId;
    private final String userPw;

    private final String userEmail;

    public UserResponse(User user){
        this.userNo = user.getUserNo();
        this.userName = user.getUserName();
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.userEmail = user.getUserEmail();
    }
}
