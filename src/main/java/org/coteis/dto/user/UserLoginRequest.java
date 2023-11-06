package org.coteis.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.coteis.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserLoginRequest {
    private String userId;
    private String userPw;
}
