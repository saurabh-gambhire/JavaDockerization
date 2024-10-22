package com.example.dockerization.service.Implemenation;

import java.util.List;

import com.example.dockerization.DTO.Response;
import com.example.dockerization.DTO.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.dockerization.entity.UserEntity;
import com.example.dockerization.repository.UserRepository;
import com.example.dockerization.service.UserService;

import lombok.RequiredArgsConstructor;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    @Autowired
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<Response> createUser(User user) {
        // Validate input
        if (ObjectUtils.isEmpty(user)) {
            throw new IllegalArgumentException("User cannot be null");
        }
    
        // Convert User to UserEntity
        UserEntity entity = UserEntity.toEntity(user);
    
        // Save the entity to the repository
        UserEntity userEntity = userRepository.save(entity);

        // Return success response
        return ResponseEntity.ok(Response.builder()
            .code(HttpStatus.CREATED)
            .message("User created successfully")
            .data(userEntity)
            .build());
    }

    @Override
    public ResponseEntity<Response> getUsers() {
        // TODO Auto-generated method stub
        List<UserEntity> users = userRepository.findAll();
        log.info("Users retrieved successfully");
        if (!users.isEmpty()) {
            return ResponseEntity.ok(Response.builder()
                .code(HttpStatus.OK)
                .message("Users retrieved successfully")
                .data(users)
                .build());
        } else {
            return ResponseEntity.ok(Response.builder()
                .code(HttpStatus.NO_CONTENT)
                .message("No users found")
                .build());
            
        }
    }
    
    
}
