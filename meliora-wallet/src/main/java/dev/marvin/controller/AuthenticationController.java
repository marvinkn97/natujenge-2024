package dev.marvin.controller;

import dev.marvin.dto.AuthenticationRequest;
import dev.marvin.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
public class AuthenticationController {

    public ResponseEntity<ResponseDto<?>> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return null;
    }
}
