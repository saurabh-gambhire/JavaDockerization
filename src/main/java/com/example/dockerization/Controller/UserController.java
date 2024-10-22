package com.example.dockerization.Controller;

import com.example.dockerization.DTO.Response;
import com.example.dockerization.DTO.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dockerization.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/master/user")
public class UserController {
    
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Response> createUser(@RequestBody User user) {
         return userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<Response> getUser() {
        return userService.getUsers();
    }
}
