package dev.marvin.controller;

import dev.marvin.dto.AuthenticationRequest;
import dev.marvin.dto.AuthenticationResponse;
import dev.marvin.dto.ResponseDto;
import dev.marvin.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
@Slf4j
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<?>> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        log.info("Inside authenticate method of AuthenticationController");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        String token = jwtService.generateToken(authentication);
        ResponseDto<Object> responseDto = ResponseDto.builder().statusCode(HttpStatus.OK.value()).status(HttpStatus.OK.getReasonPhrase()).payload(new AuthenticationResponse(token)).build();
        return ResponseEntity.ok(responseDto);
    }
}
