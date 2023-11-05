package org.coteis.dto.user;

import lombok.Getter;
import org.coteis.domain.user.User;

@Getter
public class UserLoginResponse {
    private final Long userNo;
    private final String userId;
    private final String userPw;

    public UserLoginResponse(User user){
        this.userNo = user.getUserNo();
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
    }
}
