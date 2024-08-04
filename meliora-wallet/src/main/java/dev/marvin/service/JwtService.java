package dev.marvin.service;

public interface JwtService {
    String generateToken();
    Boolean validateToken(String token);
}
