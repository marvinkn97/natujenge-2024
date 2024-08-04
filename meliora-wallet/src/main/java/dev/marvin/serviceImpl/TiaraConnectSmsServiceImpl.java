package dev.marvin.serviceImpl;

import dev.marvin.dto.SMSRequest;
import dev.marvin.dto.SMSResponse;
import dev.marvin.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TiaraConnectSmsServiceImpl implements SmsService {
    private static final Logger log = LoggerFactory.getLogger(TiaraConnectSmsServiceImpl.class);
    private final WebClient webClient;
    private static final String apiKey = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIzMzgiLCJvaWQiOjMzOCwidWlkIjoiYjEyZmY4NTgtMzY5MS00NjUwLTg2YWMtNGEwOTcxZWMzZTQ5IiwiYXBpZCI6MzQ5LCJpYXQiOjE3MjI1MjEyNjUsImV4cCI6MjA2MjUyMTI2NX0.1ivj9Aq1PB7hY7FyLGrGPK3LYRTToy3b-dxceYaR_PND_ZoxSJGeKtTOM5sYFXhrNQnwUfUuNK9FjujzHeIt0A";
    private static final String endpoint = "https://api2.tiaraconnect.io/api/messaging/sendsms";


    public TiaraConnectSmsServiceImpl() {
        this.webClient = WebClient.builder().build();
    }

    @Override
    public Mono<SMSResponse> sendSMSWithWebClient(SMSRequest smsRequest) {
        log.info("Inside sendSMS method of TiaraConnectSmsServiceImpl");
        return webClient.post()
                .uri(endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(smsRequest)
                .retrieve()
                .bodyToMono(SMSResponse.class);
    }

    @Override
    public SMSResponse sendSMSWithRestTemplate(SMSRequest smsRequest) {
        return null;
    }

    @Override
    public SMSResponse sendSMSWithJavaHttpClient(SMSRequest smsRequest) {
        return null;
    }

    @Override
    public SMSResponse sendSMSWithRestClient(SMSRequest smsRequest) {
        return null;
    }


}
