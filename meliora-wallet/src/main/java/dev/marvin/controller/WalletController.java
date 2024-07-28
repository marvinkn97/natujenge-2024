package dev.marvin.controller;

import dev.marvin.dto.RegistrationRequest;
import dev.marvin.dto.ResponseDto;
import dev.marvin.service.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallets")
@Slf4j
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping
    public ResponseEntity<ResponseDto<Object>> create(@RequestBody RegistrationRequest registrationRequest){
        log.info("Inside create method of WalletController");
        System.out.println(registrationRequest);
        ResponseDto<Object> responseDto = ResponseDto.builder()
                .statusCode(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED.getReasonPhrase())
                .payload(walletService.create(registrationRequest))
                .build();
        return ResponseEntity.ok(responseDto);
    }
}
