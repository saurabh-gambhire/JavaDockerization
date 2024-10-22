package com.example.dockerization.service;

import com.example.dockerization.DTO.Response;
import com.example.dockerization.DTO.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Response> createUser(User user);

    ResponseEntity<Response> getUsers();
}
