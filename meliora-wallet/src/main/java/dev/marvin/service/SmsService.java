package dev.marvin.service;

import dev.marvin.dto.SMSRequest;
import dev.marvin.dto.SMSResponse;
import reactor.core.publisher.Mono;

public interface SmsService {
    Mono<SMSResponse> sendSMS(SMSRequest smsRequest);
}
