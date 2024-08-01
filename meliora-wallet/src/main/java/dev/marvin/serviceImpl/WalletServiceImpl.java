package dev.marvin.serviceImpl;

import dev.marvin.dto.RegistrationRequest;
import dev.marvin.dto.SMSRequest;
import dev.marvin.exception.DuplicateResourceException;
import dev.marvin.model.User;
import dev.marvin.model.Wallet;
import dev.marvin.repository.WalletRepository;
import dev.marvin.service.SmsService;
import dev.marvin.service.UserService;
import dev.marvin.service.WalletService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Slf4j
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final UserService userService;
    private final SmsService smsService;

    @Override
    @Transactional
    public String create(RegistrationRequest registrationRequest) {
        log.info("Inside create method of WalletServiceImpl");
        try {
            User user = userService.create(registrationRequest.getUsername(), registrationRequest.getPassword());
            Wallet wallet = Wallet.builder()
                    .phoneNumber(registrationRequest.getPhoneNumber())
                    .fullName(registrationRequest.getFullName())
                    .balance(BigDecimal.ZERO)
                    .isDeleted(false)
                    .user(user)
                    .build();

            Wallet savedWallet = walletRepository.save(wallet);

            String welcomeMessage = """
                    Welcome %s to Meliora Wallet. Your account is now set up and ready to use.
                    Thank you for choosing us!
                    ~ Meliora Wallet Team
                    """.formatted(savedWallet.getFullName());

            SMSRequest smsRequest = SMSRequest.builder()
                    .message(welcomeMessage)
                    .to(savedWallet.getPhoneNumber())
                    .build();

            smsService.sendSMS(smsRequest).block();

            return "Wallet Created Successfully";
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateResourceException("phone number [%s] already taken".formatted(registrationRequest.getPhoneNumber()));
        }
    }
}
