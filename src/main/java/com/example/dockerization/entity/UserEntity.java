package com.example.dockerization.entity;

import java.util.UUID;

import com.example.dockerization.DTO.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "users")
@Data
@SuperBuilder
@RequiredArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String name;
    private String email;
    private String password;

    @PrePersist
    public void prePersist() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID();
        }
    }

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
            .id(user.getId())
            .uuid(user.getUuid())
            .name(user.getName())
            .email(user.getEmail())
            .password(user.getPassword())
            .build();
    }
}
