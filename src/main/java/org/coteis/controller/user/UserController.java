package org.coteis.controller.user;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.coteis.domain.user.User;
import org.coteis.dto.user.AddUserRequest;
import org.coteis.dto.user.UpdateUserRequest;
import org.coteis.dto.user.UserLoginRequest;
import org.coteis.dto.user.UserResponse;
import org.coteis.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request){
        User savedUser = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> findAllUsers(){
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLoginRequest request) {
        User user = userService.findLoginUser(request);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody UpdateUserRequest request){
        User updatedUser = userService.update(id, request);

        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);

        return ResponseEntity.ok().build();
    }
}
