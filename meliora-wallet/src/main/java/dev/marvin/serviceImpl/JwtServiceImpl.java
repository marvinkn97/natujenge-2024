package dev.marvin.serviceImpl;

import dev.marvin.exception.RequestValidationException;
import dev.marvin.model.User;
import dev.marvin.service.JwtService;
import dev.marvin.util.KeyGenerator;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {
    private static final SecretKey key = KeyGenerator.generateKey();

    @Override
    public String generateToken(Authentication authentication) {
        try {
            if (ObjectUtils.isEmpty(authentication) || !authentication.isAuthenticated()) {
                throw new RequestValidationException(HttpStatus.UNAUTHORIZED.getReasonPhrase());
            }

            Map<String, Object> claims = new HashMap<>();
            User user = (User) authentication.getPrincipal();
            claims.put("userId", user.getId());
            claims.put("role", user.getRole().name());

            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + 3600000); // 1 hour in milliseconds

            return Jwts.builder()
                    .issuer("meliora@wallet.co.ke")
                    .subject(user.getUsername())
                    .claims(claims)
                    .expiration(expiryDate)
                    .issuedAt(now)
                    .signWith(key)
                    .compact();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean validateToken(String token) {
        return null;
    }
}
