package dev.marvin.service;

import org.springframework.security.core.Authentication;

public interface JwtService {
    String generateToken(Authentication authentication);
    Boolean validateToken(String token);
}
