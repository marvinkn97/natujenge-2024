package dev.marvin.serviceImpl;

import dev.marvin.service.JwtService;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {
    @Override
    public String generateToken() {
        return null;
    }

    @Override
    public Boolean validateToken(String token) {
        return null;
    }
}
