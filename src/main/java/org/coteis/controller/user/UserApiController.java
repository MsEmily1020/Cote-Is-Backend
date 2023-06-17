package org.coteis.controller.user;

import lombok.RequiredArgsConstructor;
import org.coteis.dto.user.AddUserRequest;
import org.coteis.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signUp(AddUserRequest request) {
        userService.save(request);
        return "redirect:/login";
    }
}
