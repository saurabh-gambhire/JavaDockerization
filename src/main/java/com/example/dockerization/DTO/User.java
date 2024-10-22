package com.example.dockerization.DTO;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private UUID uuid;
    private String name;
    private String email;
    private String password;
}
