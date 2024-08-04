package dev.marvin.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class KeyGenerator {
    public static SecretKey generateKey() {
        javax.crypto.KeyGenerator keyGenerator;
        try {
            keyGenerator = javax.crypto.KeyGenerator.getInstance("HmacSHA256");
            keyGenerator.init(256);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            log.info("Failed to generate Key: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to generate Key");
        }
    }
}
