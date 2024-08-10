package dev.marvin.controller;

import dev.marvin.dto.RegistrationRequest;
import dev.marvin.dto.ResponseDto;
import dev.marvin.service.WalletService;
import dev.marvin.util.ResponseBuilder;
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
    public ResponseEntity<ResponseDto<Object>> create(@RequestBody RegistrationRequest registrationRequest) {
        log.info("Inside create method of WalletController");
        walletService.create(registrationRequest);
        ResponseDto<Object> responseDto = ResponseBuilder.buildResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase(), "Wallet Created Successfully");
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<ResponseDto<Object>> get(@RequestParam("userId") Integer userId) {
        log.info("Inside get method of WalletController");
        ResponseDto<Object> responseDto = ResponseBuilder.buildResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), walletService.get(userId));
        return ResponseEntity.ok(responseDto);
    }
}
