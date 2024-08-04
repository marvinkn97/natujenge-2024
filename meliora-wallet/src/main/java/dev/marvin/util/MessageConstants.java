package dev.marvin.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageConstants {
    WALLET_CREATED("Wallet Created Successfully"),
    DUPLICATE_PHONE_NUMBER("phone number [%s] already taken"),
    WALLET_NOT_FOUND("Wallet not found");

    private final String message;
}
