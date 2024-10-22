package com.example.dockerization.DTO;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Response {
    private HttpStatus code;
    @JsonDeserialize(as = String.class)
    private Object message;

    @JsonDeserialize(as = String.class)
    private Object data;
    private String path;
    private String requestId;
    private String version;
}
