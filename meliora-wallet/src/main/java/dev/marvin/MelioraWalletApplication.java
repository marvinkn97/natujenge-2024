package dev.marvin;

import dev.marvin.dto.SMSRequest;
import dev.marvin.dto.SMSResponse;
import dev.marvin.service.SmsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class MelioraWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(MelioraWalletApplication.class, args);
    }


//	@Bean
    public CommandLineRunner runner(SmsService service) {
        return args -> {

            SMSRequest smsRequest = SMSRequest.builder()
                    .to("254792865297")
                    .message("Testing Meliora Wallet")
                    .build();

            Mono<SMSResponse> smsResponseMono = service.sendSMSWithWebClient(smsRequest);
            System.out.println(smsResponseMono.block());

        };
    }
}
