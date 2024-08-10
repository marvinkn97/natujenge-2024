package dev.marvin.service;

import dev.marvin.dto.RegistrationRequest;
import dev.marvin.dto.WalletResponse;

public interface WalletService {
    void create(RegistrationRequest registrationRequest);
    WalletResponse get(Integer userId);
}
