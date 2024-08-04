package dev.marvin.service;

import dev.marvin.dto.RegistrationRequest;
import dev.marvin.dto.WalletResponse;

public interface WalletService {
    String create(RegistrationRequest registrationRequest);
    WalletResponse get(Integer userId);
}
