package dev.marvin.dto;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String username;
    private String fullName;
    private String phoneNumber;
    private String password;
}
