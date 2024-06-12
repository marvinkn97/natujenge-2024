package com.example.demo;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private Integer status;
    private String reason;
    private String message;
}
