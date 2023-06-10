package org.coteis.controller;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.User;
import org.coteis.dto.AddUserRequest;
import org.coteis.dto.UpdateUserRequest;
import org.coteis.dto.UserResponse;
import org.coteis.service.UserService;
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

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,
                                           @RequestBody UpdateUserRequest request){
        User updatedUser = userService.update(id, request);

        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        userService.delete(id);

        return ResponseEntity.ok().build();
    }
}
