package org.coteis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequest {
    private Long id;
    private String userName;
    private String userId;
    private String userPw;
    private String uesrEmail;
}
