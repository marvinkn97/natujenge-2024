package dev.marvin.service;

import dev.marvin.dto.SMSRequest;
import dev.marvin.dto.SMSResponse;
import reactor.core.publisher.Mono;

public interface SmsService {
    Mono<SMSResponse> sendSMSWithWebClient(SMSRequest smsRequest);
    SMSResponse sendSMSWithRestTemplate(SMSRequest smsRequest);
    SMSResponse sendSMSWithJavaHttpClient(SMSRequest smsRequest);
    SMSResponse sendSMSWithRestClient(SMSRequest smsRequest);
}
