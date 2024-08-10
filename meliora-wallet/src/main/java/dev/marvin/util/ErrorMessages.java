package dev.marvin.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ErrorMessages {

    @Value("${error.message.general.not-found}")
    private String notFound;

    @Value("${error.message.wallet.duplicate-phone-number}")
    private String duplicatePhone;
}
